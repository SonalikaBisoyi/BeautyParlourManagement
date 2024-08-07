package com.beautyparlour.controller;

import com.beautyparlour.dao.StaffDAO;
import com.beautyparlour.model.Staff;
import com.beautyparlour.util.DatabaseUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StaffServlet", urlPatterns = {"/admin/staff/*"})
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StaffDAO staffDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection connection = DatabaseUtil.getConnection();
            staffDAO = new StaffDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Error initializing database connection", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/delete":
                deleteStaff(request, response);
                break;
            default:
                listStaff(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/add":
                insertStaff(request, response);
                break;
            case "/update":
                updateStaff(request, response);
                break;
            default:
                listStaff(request, response);
                break;
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Staff> staffList = staffDAO.getAllStaff();
            request.setAttribute("staffList", staffList);
            request.getRequestDispatcher("/adm/manageStaff.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/adm/newStaff.jsp").forward(request, response);
    }

    private void insertStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        double salary = Double.parseDouble(request.getParameter("salary"));
        Date dateOfHire = Date.valueOf(request.getParameter("dateOfHire")); // Parse input to java.sql.Date
        String address = request.getParameter("address");
        String status = request.getParameter("status");

        // Debugging: Print received parameters
        System.out.println("Received parameters for new staff:");
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("position: " + position);
        System.out.println("salary: " + salary);
        System.out.println("dateOfHire: " + dateOfHire);
        System.out.println("address: " + address);
        System.out.println("status: " + status);

        // Create new Staff object
        Staff newStaff = new Staff(firstName, lastName, email, phone, position, salary, dateOfHire, address, status);

        try {
            // Add staff to database
            staffDAO.addStaff(newStaff);
            System.out.println("New staff added successfully.");

            // Redirect to staff list after adding
            response.sendRedirect("list");
        } catch (SQLException e) {
            throw new ServletException("Error adding new staff", e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        try {
            Staff existingStaff = staffDAO.getStaffById(staffId);
            request.setAttribute("staff", existingStaff);
            request.getRequestDispatcher("/adm/editStaff.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String dateOfHireString = request.getParameter("dateOfHire"); // Date as string

        // Parse dateOfHireString to java.sql.Date
        Date dateOfHire = null;
        try {
            dateOfHire = Date.valueOf(dateOfHireString);
        } catch (IllegalArgumentException e) {
            throw new ServletException("Invalid date format for dateOfHire", e);
        }

        String address = request.getParameter("address");
        String status = request.getParameter("status");

        // Debugging: Print received parameters
        System.out.println("Received parameters for staff update:");
        System.out.println("staffId: " + staffId);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("position: " + position);
        System.out.println("salary: " + salary);
        System.out.println("dateOfHire: " + dateOfHire);
        System.out.println("address: " + address);
        System.out.println("status: " + status);

        // Create new Staff object
        Staff staff = new Staff(staffId, firstName, lastName, email, phone, position, salary, dateOfHire, address, status);

        try {
            // Update staff in database
            staffDAO.updateStaff(staff);
            System.out.println("Staff updated successfully.");

            // Redirect to staff list after updating
            response.sendRedirect("list");
        } catch (SQLException e) {
            throw new ServletException("Error updating staff", e);
        }
    }


    private void deleteStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        try {
            // Delete staff from database
            staffDAO.deleteStaff(staffId);
            System.out.println("Staff deleted successfully.");

            // Redirect to staff list after deletion
            response.sendRedirect("list");
        } catch (SQLException e) {
            throw new ServletException("Error deleting staff", e);
        }
    }
}
