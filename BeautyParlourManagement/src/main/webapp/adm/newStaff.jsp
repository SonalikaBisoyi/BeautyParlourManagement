<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Staff - Admin Dashboard</title>
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
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Staff</h1>
        <form action="<%= request.getContextPath() %>/admin/staff/add" method="post">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
            
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required>
            
            <label for="position">Position:</label>
            <select id="position" name="position" required>
                <option value="Hair Stylist">Hair Stylist</option>
                <option value="Beautician">Beautician</option>
                <option value="Nail Technician">Nail Technician</option>
                <!-- Add more options as needed -->
            </select>
            
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" step="0.01" required>
            
            <label for="dateOfHire">Date of Hire:</label>
            <input type="date" id="dateOfHire" name="dateOfHire" required>
            
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="4" required></textarea>
            
            <label for="status">Status:</label>
<select id="status" name="status" required>
    <option value="Active">Active</option>
    <option value="Inactive">Inactive</option>
</select>

            
            <button type="submit">Add Staff</button>
        </form>
    </div>
</body>
</html>
