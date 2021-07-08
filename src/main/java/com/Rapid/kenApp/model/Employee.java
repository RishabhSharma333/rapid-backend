package com.Rapid.kenApp.model;

import javax.persistence.*;

@Entity
@Table(name = "employees_list")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String first_name;
    private String last_name;
    private Integer salary;
    private String department;
    private String position;
    private String email_address;
    private String contact_number;
    @Lob
    @Column(name = "picByte")
    private  byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Employee() {

    }

    public Employee(String first_name, String last_name, Integer salary, String department, String position, String email_address, String contact_number, byte[] image) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email_address = email_address;
        this.contact_number = contact_number;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }


}
