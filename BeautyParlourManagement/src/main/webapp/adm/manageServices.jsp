<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.beautyparlour.model.Service" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Services - Admin Dashboard</title>
    <!-- Include any necessary CSS or JavaScript files here -->
    <style>
        /* Your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .actions {
            text-align: center;
        }
        .actions a {
            margin-right: 10px;
            padding: 5px 10px;
            text-decoration: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 4px;
        }
        .actions a:hover {
            background-color: #0056b3;
        }
        .add-button {
            text-align: right;
            margin-top: 10px;
        }
        .add-button a {
            padding: 10px 20px;
            background-color: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
        .add-button a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Manage Services</h1>
        <table>
            <thead>
                <tr>
                    <th>Service ID</th>
                    <th>Service Name</th>
                    <th>Description</th>
                    <th>Price ($)</th>
                    <th>Expected Time (minutes)</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%@ page import="java.util.List" %>
                <%@ page import="com.beautyparlour.model.Service" %>
                <!-- Ensure that 'services' is properly set in the servlet before forwarding -->
                <% List<Service> services = (List<Service>) request.getAttribute("services"); %>
                <% if (services != null && !services.isEmpty()) { %>
                    <% for (Service service : services) { %>
                        <tr>
                            <td><%= service.getServiceId() %></td>
                            <td><%= service.getServiceName() %></td>
                            <td><%= service.getDescription() %></td>
                            <td><%= service.getPrice() %></td>
                            <td><%= service.getExpectedTime() %></td>
                            <td class="actions">
                                <a href="<%= request.getContextPath() %>/admin/services/edit?serviceId=<%= service.getServiceId() %>">Edit</a>
                                <a href="<%= request.getContextPath() %>/admin/services/delete?serviceId=<%= service.getServiceId() %>" onclick="return confirm('Are you sure you want to delete this service?')">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="6" style="text-align: center;">No services found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <div class="add-button">
            <a href="<%= request.getContextPath() %>/adm/newService.jsp">Add New Service</a>
        </div>
    </div>
</body>
</html>