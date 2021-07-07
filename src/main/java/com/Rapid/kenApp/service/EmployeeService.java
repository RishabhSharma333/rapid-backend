package com.Rapid.kenApp.service;



import com.Rapid.kenApp.model.Employee;
import com.Rapid.kenApp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getByPosition(String pos) {
        return employeeRepo.findByPosition(pos);
    }

    public List<Employee> getByDepartment(String dept) {
        return employeeRepo.findByDepartment(dept);
    }

    public List<Employee> getByLimit(int limit) {
        return employeeRepo.findByLimit(limit);
    }



    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }

    public void updateEmployee(Employee employee, long id) {
        Employee employee1 = this.employeeRepo.getById(id);
        employee1.setContact_number(employee.getContact_number());
        employee1.setDepartment(employee.getDepartment());
        employee1.setEmail_address(employee.getEmail_address());
        employee1.setFirst_name(employee.getFirst_name());
        employee1.setPosition(employee.getPosition());
        employee1.setSalary(employee.getSalary());
        employee1.setLast_name(employee.getLast_name());
        employee1.setImage(employee.getImage());
        employeeRepo.save(employee1);
    }

    public void addEmployee(String imageFile,String first_name,String last_name,String contact,String email,String position,int salary,String dept) {

       Employee emp=new Employee();

        emp.setImage(imageFile);
        emp.setSalary(salary);
        emp.setPosition(position);
        emp.setFirst_name(first_name);
        emp.setEmail_address(email);
        emp.setDepartment(dept);
        emp.setLast_name(last_name);
        emp.setContact_number(contact);
        employeeRepo.save(emp);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepo.getById(id);
    }



}
