<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beautyparlour.model.Staff" %>
<% Staff staff = (Staff) request.getAttribute("staff"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Staff - Admin Dashboard</title>
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
        input, select {
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
        <h1>Edit Staff</h1>
        <form action="<%= request.getContextPath() %>/admin/staff/update" method="post">
            <input type="hidden" id="staffId" name="staffId" value="<%= staff.getStaffId() %>">
            
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="<%= staff.getFirstName() %>" required>
            
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="<%= staff.getLastName() %>" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= staff.getEmail() %>" required>
            
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" value="<%= staff.getPhone() %>" pattern="[0-9]{10}" required>
            
            <label for="position">Position:</label>
            <select id="position" name="position" required>
                <option value="Hair Stylist" <%= staff.getPosition().equals("Hair Stylist") ? "selected" : "" %>>Hair Stylist</option>
                <option value="Beautician" <%= staff.getPosition().equals("Beautician") ? "selected" : "" %>>Beautician</option>
                <option value="Nail Technician" <%= staff.getPosition().equals("Nail Technician") ? "selected" : "" %>>Nail Technician</option>
                <!-- Add more options as needed -->
            </select>
            
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" value="<%= staff.getSalary() %>" step="0.01" required>
            
            <label for="dateOfHire">Date of Hire:</label>
            <input type="date" id="dateOfHire" name="dateOfHire" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(staff.getDateOfHire()) %>" required>
            
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="4" required><%= staff.getAddress() %></textarea>
            
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Active" <%= staff.getStatus().equals("Active") ? "selected" : "" %>>Active</option>
                <option value="Inactive" <%= staff.getStatus().equals("Inactive") ? "selected" : "" %>>Inactive</option>
            </select>
            
            <button type="submit">Update Staff</button>
        </form>
    </div>
</body>
</html>
