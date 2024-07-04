package com.beautyparlour.controller;

import com.beautyparlour.dao.UserDAO;
import com.beautyparlour.model.User;
import com.beautyparlour.util.DatabaseUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AuthServlet", urlPatterns = {"/auth/*"})
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    // Constant admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection connection = DatabaseUtil.getConnection();
            userDAO = new UserDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Error initializing database connection", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/register":
                registerUser(request, response);
                break;
            case "/login":
                loginUser(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Admin cannot be registered
        if (ADMIN_USERNAME.equals(username)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Admin cannot be registered.");
            return;
        }

        User newUser = new User(username, password, fullName, email, phone, address);
        try {
            userDAO.addUser(newUser);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error registering user", e);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            response.sendRedirect(request.getContextPath() + "/adm/dashboard.jsp");
        } else {
            try {
                User user = userDAO.getUserByUsername(username);
                if (user != null && user.getPassword().equals(password)) {
                    response.sendRedirect(request.getContextPath() + "/user/dashboard.jsp");
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials.");
                }
            } catch (SQLException e) {
                throw new ServletException("Error logging in user", e);
            }
        }
    }
}
