package com.beautyparlour.dao;

import com.beautyparlour.model.Service;
import com.beautyparlour.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    private Connection connection;

    public ServiceDAO(Connection connection) {
        this.connection = connection;
    }

    public void addService(Service service) throws SQLException {
        String query = "INSERT INTO services (service_name, description, price, expected_time) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, service.getServiceName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setInt(4, service.getExpectedTime());

            int affectedRows = statement.executeUpdate();

            // Check if insert was successful and get the generated ID
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        service.setServiceId(generatedKeys.getInt(1));
                    }
                }
            }
        }
    }

    public List<Service> getAllServices() throws SQLException {
        List<Service> services = new ArrayList<>();
        String query = "SELECT * FROM services";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setDescription(resultSet.getString("description"));
                service.setPrice(resultSet.getDouble("price"));
                service.setExpectedTime(resultSet.getInt("expected_time"));

                services.add(service);
            }
        }
        return services;
    }

    public Service getServiceById(int serviceId) throws SQLException {
        String query = "SELECT * FROM services WHERE service_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, serviceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Service service = new Service();
                    service.setServiceId(resultSet.getInt("service_id"));
                    service.setServiceName(resultSet.getString("service_name"));
                    service.setDescription(resultSet.getString("description"));
                    service.setPrice(resultSet.getDouble("price"));
                    service.setExpectedTime(resultSet.getInt("expected_time"));

                    return service;
                }
            }
        }
        return null;
    }

    public void updateService(Service service) throws SQLException {
        String query = "UPDATE services SET service_name = ?, description = ?, price = ?, expected_time = ? WHERE service_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, service.getServiceName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setInt(4, service.getExpectedTime());
            statement.setInt(5, service.getServiceId());

            statement.executeUpdate();
        }
    }

    public void deleteService(int serviceId) throws SQLException {
        String query = "DELETE FROM services WHERE service_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, serviceId);
            statement.executeUpdate();
        }
    }
}
