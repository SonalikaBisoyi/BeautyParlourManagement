package com.beautyparlour.model;

import java.util.Date;

public class Staff {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private double salary;
    private Date dateOfHire;
    private String status;
    private String address;

    // Constructor for adding a new staff member
    public Staff(String firstName, String lastName, String email, String phone, String position, double salary, Date dateOfHire, String status, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.dateOfHire = dateOfHire;
        this.status = status;
        this.address = address;
    }

    // Constructor for updating an existing staff member
    public Staff(int staffId, String firstName, String lastName, String email, String phone, String position, double salary, Date dateOfHire, String status, String address) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.dateOfHire = dateOfHire;
        this.status = status;
        this.address = address;
    }

    // Getters and setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(Date dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
