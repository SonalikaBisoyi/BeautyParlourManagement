package com.beautyparlour.model;

public class Service {
    private int serviceId;
    private String serviceName;
    private String description;
    private double price;
    private int expectedTime;  // Time in minutes

    // Constructors
    public Service() {
        // Default constructor
    }

    public Service(String serviceName, String description, double price, int expectedTime) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.expectedTime = expectedTime;
    }

    public Service(int serviceId, String serviceName, String description, double price, int expectedTime) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.expectedTime = expectedTime;
    }

    // Getters and setters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(int expectedTime) {
        this.expectedTime = expectedTime;
    }
}