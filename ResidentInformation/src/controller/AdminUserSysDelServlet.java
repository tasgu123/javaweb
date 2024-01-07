package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SystemBulletinService;
import service.impl.SystemBulletinServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/systemBulletin/del")
public class AdminUserSysDelServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty()) {
            systemBulletinService.del(Integer.parseInt(id));
        }
        resp.sendRedirect("list");
    }
}
