package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminUser;
import service.AdminUserService;
import service.impl.AdminUserServiceImpl;

import java.io.IOException;

@WebServlet("/admin/adminUsers/add")
public class AdminUserAddServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(req.getParameter("username"));
        adminUser.setPassword(req.getParameter("password"));
        adminUser.setId(Integer.parseInt(req.getParameter("id")));
        adminUserService.add(adminUser);
        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
