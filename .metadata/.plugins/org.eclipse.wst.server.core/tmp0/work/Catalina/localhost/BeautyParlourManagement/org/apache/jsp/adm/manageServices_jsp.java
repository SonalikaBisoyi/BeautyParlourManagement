/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.12
 * Generated at: 2024-07-03 20:39:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.adm;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import com.beautyparlour.model.Service;
import java.util.List;
import com.beautyparlour.model.Service;

public final class manageServices_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.beautyparlour.model.Service");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Manage Services - Admin Dashboard</title>\r\n");
      out.write("    <!-- Include any necessary CSS or JavaScript files here -->\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Your CSS styles here */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background-color: #f0f0f0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            max-width: 800px;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        table {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        th, td {\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("        }\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #f2f2f2;\r\n");
      out.write("        }\r\n");
      out.write("        .actions {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        .actions a {\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("            padding: 5px 10px;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            background-color: #007bff;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .actions a:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("        .add-button {\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .add-button a {\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            background-color: #28a745;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .add-button a:hover {\r\n");
      out.write("            background-color: #218838;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Manage Services</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Service ID</th>\r\n");
      out.write("                    <th>Service Name</th>\r\n");
      out.write("                    <th>Description</th>\r\n");
      out.write("                    <th>Price ($)</th>\r\n");
      out.write("                    <th>Expected Time (minutes)</th>\r\n");
      out.write("                    <th>Actions</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <!-- Ensure that 'services' is properly set in the servlet before forwarding -->\r\n");
      out.write("                ");
 List<Service> services = (List<Service>) request.getAttribute("services"); 
      out.write("\r\n");
      out.write("                ");
 if (services != null && !services.isEmpty()) { 
      out.write("\r\n");
      out.write("                    ");
 for (Service service : services) { 
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print( service.getServiceId() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( service.getServiceName() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( service.getDescription() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( service.getPrice() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( service.getExpectedTime() );
      out.write("</td>\r\n");
      out.write("                            <td class=\"actions\">\r\n");
      out.write("                                <a href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/services/edit?serviceId=");
      out.print( service.getServiceId() );
      out.write("\">Edit</a>\r\n");
      out.write("                                <a href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/services/delete?serviceId=");
      out.print( service.getServiceId() );
      out.write("\" onclick=\"return confirm('Are you sure you want to delete this service?')\">Delete</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                ");
 } else { 
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"6\" style=\"text-align: center;\">No services found.</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <div class=\"add-button\">\r\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath() );
      out.write("/adm/newService.jsp\">Add New Service</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}