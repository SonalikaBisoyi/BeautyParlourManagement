package com.beautyparlour.controller;

import com.beautyparlour.dao.ServiceDAO;
import com.beautyparlour.model.Service;
import com.beautyparlour.util.DatabaseUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/admin/services/*"})
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection connection = DatabaseUtil.getConnection();
            serviceDAO = new ServiceDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Error initializing database connection", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/delete":
                    deleteService(request, response);
                    break;
                default:
                    listServices(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/add":
                    insertService(request, response);
                    break;
                case "/update":
                    updateService(request, response);
                    break;
                default:
                    listServices(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listServices(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Service> listService = serviceDAO.getAllServices();
        request.setAttribute("services", listService);
        request.getRequestDispatcher("/adm/manageServices.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/adm/newService.jsp").forward(request, response);
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int expectedTime = Integer.parseInt(request.getParameter("expectedTime"));

        System.out.println("Service Name: " + serviceName);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Expected Time: " + expectedTime);

        Service newService = new Service(serviceName, description, price, expectedTime);
        serviceDAO.addService(newService);
        response.sendRedirect(request.getContextPath() + "/admin/services/list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        Service existingService = serviceDAO.getServiceById(serviceId);
        request.setAttribute("service", existingService);
        request.getRequestDispatcher("/adm/editService.jsp").forward(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int expectedTime = Integer.parseInt(request.getParameter("expectedTime"));

        Service service = new Service(serviceId, serviceName, description, price, expectedTime);
        serviceDAO.updateService(service);
        response.sendRedirect(request.getContextPath() + "/admin/services/list");
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        serviceDAO.deleteService(serviceId);
        response.sendRedirect(request.getContextPath() + "/admin/services/list");
    }
}
