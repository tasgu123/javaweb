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
import java.util.List;

@WebServlet(urlPatterns = {"/admin/adminUsers/list", "/admin/adminUsers/query"})
public class AdminUserListServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<AdminUser> users = adminUserService.get(null);
        req.setAttribute("AdminUser", users);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
