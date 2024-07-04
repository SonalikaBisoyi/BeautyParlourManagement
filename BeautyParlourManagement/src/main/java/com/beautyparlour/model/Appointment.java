package com.beautyparlour.model;

import java.sql.Timestamp;

public class Appointment {
    private int appointmentId;
    private String customerName;
    private String service;
    private Timestamp appointmentDate;
    private String status;
    private String notes;
    private Timestamp createdAt;

    public Appointment() {
        // Default constructor
    }


        // Constructor without appointmentId (for creating new appointments)
        public Appointment(String customerName, String service, Timestamp appointmentDate, String status, String notes, Timestamp createdAt) {
            this.customerName = customerName;
            this.service = service;
            this.appointmentDate = appointmentDate;
            this.status = status;
            this.notes = notes;
            this.createdAt = createdAt;
        }

        // Constructor with appointmentId (for updating existing appointments)
        public Appointment(int appointmentId, String customerName, String service, Timestamp appointmentDate, String status, String notes, Timestamp createdAt) {
            this.appointmentId = appointmentId;
            this.customerName = customerName;
            this.service = service;
            this.appointmentDate = appointmentDate;
            this.status = status;
            this.notes = notes;
            this.createdAt = createdAt;
        }

    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // toString() method to print object details
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", customerName='" + customerName + '\'' +
                ", service='" + service + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
