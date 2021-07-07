package com.Rapid.kenApp.controller;

import com.Rapid.kenApp.model.DepartmentRequest;
import com.Rapid.kenApp.model.Employee;
import com.Rapid.kenApp.model.LimitRequest;
import com.Rapid.kenApp.model.PositionRequest;
import com.Rapid.kenApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/filterPosition")
    public List<Employee> getByPosition(@RequestBody PositionRequest position) {
        return employeeService.getByPosition(position.getPosition());
    }

    @PostMapping("/filterDepartment")
    public List<Employee> getByDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return employeeService.getByDepartment(departmentRequest.getDepartment());
    }

    @PostMapping("/filterLimit")
    public List<Employee> getByLimit(@RequestBody LimitRequest limitRequest) {
        return employeeService.getByLimit(limitRequest.getLimit());
    }


    @GetMapping("/pagination")
    public List<Employee> getEmployeesByLimit(@RequestParam Integer limit) {
        return employeeService.getByLimit(limit);
    }

    @PostMapping(value="/add")
    public void addEmployee(@RequestParam("image") String image, @RequestParam("first_name") String first_name,
                            @RequestParam("last_name") String last_name, @RequestParam("contact_number") String contact_number, @RequestParam("department") String department, @RequestParam("position") String position, @RequestParam("salary") int salary, @RequestParam("email_address") String email_address) throws IOException {

        employeeService.addEmployee(image,first_name,last_name,contact_number,email_address,position,salary,department);
    }

    @PutMapping("/update/{id}")
    public void editEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


}
