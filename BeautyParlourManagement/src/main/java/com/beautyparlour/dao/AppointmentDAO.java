package com.beautyparlour.dao;

import com.beautyparlour.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (customer_name, service, appointment_date, status, notes, created_at) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, appointment.getCustomerName());
            statement.setString(2, appointment.getService());
            statement.setTimestamp(3, appointment.getAppointmentDate());
            statement.setString(4, appointment.getStatus());
            statement.setString(5, appointment.getNotes());
            statement.setTimestamp(6, appointment.getCreatedAt());

            int affectedRows = statement.executeUpdate();

            // Check if insert was successful and get the generated ID
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        appointment.setAppointmentId(generatedKeys.getInt(1));
                    }
                }
            }
        }
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(resultSet.getInt("appointment_id"));
                appointment.setCustomerName(resultSet.getString("customer_name"));
                appointment.setService(resultSet.getString("service"));
                appointment.setAppointmentDate(resultSet.getTimestamp("appointment_date"));
                appointment.setStatus(resultSet.getString("status"));
                appointment.setNotes(resultSet.getString("notes"));
                appointment.setCreatedAt(resultSet.getTimestamp("created_at"));

                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public Appointment getAppointmentById(int appointmentId) throws SQLException {
        String query = "SELECT * FROM appointments WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(resultSet.getInt("appointment_id"));
                    appointment.setCustomerName(resultSet.getString("customer_name"));
                    appointment.setService(resultSet.getString("service"));
                    appointment.setAppointmentDate(resultSet.getTimestamp("appointment_date"));
                    appointment.setStatus(resultSet.getString("status"));
                    appointment.setNotes(resultSet.getString("notes"));
                    appointment.setCreatedAt(resultSet.getTimestamp("created_at"));

                    return appointment;
                }
            }
        }
        return null;
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        String query = "UPDATE appointments SET customer_name = ?, service = ?, appointment_date = ?, " +
                       "status = ?, notes = ?, created_at = ? WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, appointment.getCustomerName());
            statement.setString(2, appointment.getService());
            statement.setTimestamp(3, appointment.getAppointmentDate());
            statement.setString(4, appointment.getStatus());
            statement.setString(5, appointment.getNotes());
            statement.setTimestamp(6, appointment.getCreatedAt());
            statement.setInt(7, appointment.getAppointmentId());

            statement.executeUpdate();
        }
    }

    public void cancelAppointment(int appointmentId) throws SQLException {
        String query = "UPDATE appointments SET status = 'Cancelled' WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointmentId);
            statement.executeUpdate();
        }
    }

    public List<Appointment> getAppointmentsByUser(int userId) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(resultSet.getInt("appointment_id"));
                appointment.setCustomerName(resultSet.getString("customer_name"));
                appointment.setService(resultSet.getString("service"));
                appointment.setAppointmentDate(resultSet.getTimestamp("appointment_date"));
                appointment.setStatus(resultSet.getString("status"));
                appointment.setNotes(resultSet.getString("notes"));
                appointment.setCreatedAt(resultSet.getTimestamp("created_at"));

                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public void deleteAppointment(int appointmentId) throws SQLException {
        String query = "DELETE FROM appointments WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointmentId);
            statement.executeUpdate();
        }
    }
}
