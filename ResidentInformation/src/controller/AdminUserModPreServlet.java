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

@WebServlet(urlPatterns = {"/admin/adminUsers/modPre"})
public class AdminUserModPreServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        if (sid != null && !sid.equals("")) {
            AdminUser adminUser = adminUserService.get(Integer.parseInt(sid));
            req.setAttribute("oldAdminUser", adminUser);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
        resp.sendRedirect("list");
    }
}
