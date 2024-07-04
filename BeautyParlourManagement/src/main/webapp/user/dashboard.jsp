<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="../assets/css/styles.css"> <!-- Adjust path as needed -->
</head>
<body>
    <header>
        <h1>User Dashboard</h1>
        <nav>
            <ul>
                <li><a href="bookAppointment.jsp">Book Appointment</a></li>
                <li><a href="submitFeedback.jsp">Submit Feedback</a></li>
                <li><a href="<c:url value='/logout' />">Logout</a></li> <!-- Example logout link -->
            </ul>
        </nav>
    </header>

    <main>
        <section id="appointments">
            <h2>Appointments</h2>
            <!-- List of upcoming appointments can be displayed here -->
        </section>

        <section id="feedback">
            <h2>Feedback</h2>
            <!-- List of feedback submissions can be displayed here -->
        </section>
    </main>

    <script src="../assets/js/scripts.js"></script> <!-- Adjust path as needed -->
</body>
</html>
