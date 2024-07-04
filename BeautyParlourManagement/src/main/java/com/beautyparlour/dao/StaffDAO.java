package com.beautyparlour.dao;

import com.beautyparlour.model.Staff;
import com.beautyparlour.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    private Connection connection;

    public StaffDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStaff(Staff staff) throws SQLException {
        String query = "INSERT INTO staff (firstName, lastName, email, phone, position, salary, dateOfHire, address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPhone());
            statement.setString(5, staff.getPosition());
            statement.setDouble(6, staff.getSalary());
            statement.setDate(7, (Date) staff.getDateOfHire()); // Use setDate for SQL DATE type
            statement.setString(8, staff.getAddress());
            statement.setString(9, staff.getStatus());
            

            statement.executeUpdate();

            // Get auto-generated keys (if any)
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int staffId = generatedKeys.getInt(1);
                staff.setStaffId(staffId);  // Set the generated staff ID
            }
        }
    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM staff";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = mapResultSetToStaff(resultSet);
                staffList.add(staff);
            }
        }
        return staffList;
    }

    public Staff getStaffById(int staffId) throws SQLException {
        String query = "SELECT * FROM staff WHERE staff_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToStaff(resultSet);
            }
        }
        return null;
    }

    public void updateStaff(Staff staff) throws SQLException {
        String query = "UPDATE staff SET firstName = ?, lastName = ?, email = ?, phone = ?, position = ?, salary = ?, dateOfHire = ?, address = ?, status = ? WHERE staff_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPhone());
            statement.setString(5, staff.getPosition());
            statement.setDouble(6, staff.getSalary());
            statement.setDate(7, new java.sql.Date(staff.getDateOfHire().getTime())); // Use java.sql.Date for date_of_hire
            statement.setString(8, staff.getAddress());
            statement.setString(9, staff.getStatus());
            statement.setInt(10, staff.getStaffId());

            statement.executeUpdate();
        }
    }

    public void deleteStaff(int staffId) throws SQLException {
        String query = "DELETE FROM staff WHERE staff_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffId);
            statement.executeUpdate();
        }
    }

    private Staff mapResultSetToStaff(ResultSet resultSet) throws SQLException {
        int staffId = resultSet.getInt("staff_id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        String position = resultSet.getString("position");
        double salary = resultSet.getDouble("salary");
        java.sql.Date dateOfHire = resultSet.getDate("dateOfHire"); // Use java.sql.Date for date_of_hire
        String address = resultSet.getString("address");
        String status = resultSet.getString("status");

        Staff staff = new Staff(firstName, lastName, email, phone, position, salary, dateOfHire, address, status);
        staff.setStaffId(staffId);
        return staff;
    }
}
