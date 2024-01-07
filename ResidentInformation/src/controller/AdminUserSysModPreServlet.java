package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SystemBulletin;
import service.SystemBulletinService;
import service.impl.SystemBulletinServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/systemBulletin/modPre")
public class AdminUserSysModPreServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty()) {
            SystemBulletin systemBulletin = systemBulletinService.get(Integer.parseInt(id));
            req.setAttribute("oldSystemBulletin", systemBulletin);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
        resp.sendRedirect("list");
    }
}
