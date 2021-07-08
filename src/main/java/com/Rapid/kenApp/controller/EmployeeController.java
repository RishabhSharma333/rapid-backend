package com.Rapid.kenApp.controller;

import com.Rapid.kenApp.model.DepartmentRequest;
import com.Rapid.kenApp.model.Employee;
import com.Rapid.kenApp.model.LimitRequest;
import com.Rapid.kenApp.model.PositionRequest;
import com.Rapid.kenApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {
    private byte [] picture;

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

    @PostMapping("/upload")
    public void uploadImage(@RequestParam ("imageFile") MultipartFile file) throws IOException{
        this.picture=file.getBytes();
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Employee employee) throws IOException {
        employee.setImage(this.picture);
        employeeService.addEmployee(employee);
        this.picture = null;
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
