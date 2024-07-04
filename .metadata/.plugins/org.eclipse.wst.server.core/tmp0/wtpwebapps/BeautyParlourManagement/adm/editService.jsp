<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beautyparlour.model.Service" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Service - Admin Dashboard</title>
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
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
            font-weight: bold;
        }
        input, textarea {
            margin-bottom: 20px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Service</h1>
        <% Service service = (Service) request.getAttribute("service"); %>
        <form action="<%= request.getContextPath() %>/admin/services/update" method="post">
            <input type="hidden" name="serviceId" value="<%= service.getServiceId() %>">
            
            <label for="serviceName">Service Name:</label>
            <input type="text" id="serviceName" name="serviceName" value="<%= service.getServiceName() %>" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required><%= service.getDescription() %></textarea>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" value="<%= service.getPrice() %>" required>
            
            <label for="expectedTime">Expected Time (minutes):</label>
            <input type="number" id="expectedTime" name="expectedTime" value="<%= service.getExpectedTime() %>" required>
            
            <button type="submit">Update Service</button>
        </form>
    </div>
</body>
</html>
