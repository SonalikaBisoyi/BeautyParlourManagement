package com.beautyparlour.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/*"})
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();

        switch (action) {
            case "/manageAppointments":
                // Forward to manageAppointments.jsp
                request.getRequestDispatcher("/adm/manageAppointments.jsp").forward(request, response);
                break;
            case "/manageStaff":
                // Forward to manageStaff.jsp
                request.getRequestDispatcher("/adm/manageStaff.jsp").forward(request, response);
                break;
            case "/manageServices":
                // Forward to manageServices.jsp
                request.getRequestDispatcher("/adm/manageServices.jsp").forward(request, response);
                break;
            case "/manageCustomers":
                // Forward to manageCustomers.jsp
                request.getRequestDispatcher("/adm/manageCustomers.jsp").forward(request, response);
                break;
            case "/viewFeedback":
                // Forward to viewFeedback.jsp or handle feedback logic
                request.getRequestDispatcher("/adm/viewFeedback.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle any POST requests for admin actions if needed
    }
}