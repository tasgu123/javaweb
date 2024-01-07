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

@WebServlet(urlPatterns = {"/admin/adminUsers/mod"})
public class AdminUserModServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        AdminUser adminUser = new AdminUser();
        adminUser.setId(Integer.parseInt(req.getParameter("id")));
        adminUser.setUsername(req.getParameter("username"));
        adminUser.setPassword(req.getParameter("password"));
        adminUser.setCreateTime(Long.parseLong(req.getParameter("createTime")));
        adminUser.setCreateTime(Long.parseLong(req.getParameter("lastAccessTime")));
        if (adminUserService.upt(adminUser)) {
            resp.sendRedirect("list");
        } else {
            req.setAttribute("adminUser", adminUser);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
    }
}
