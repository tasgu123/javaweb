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

@WebServlet(urlPatterns = "/admin/systemBulletin/mod")
public class AdminUserSysModServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String sysName = req.getParameter("name");
        String date = req.getParameter("date");
        String adminName = req.getParameter("adminName");
        SystemBulletin systemBulletin = new SystemBulletin();
        if (id != null && !id.isEmpty()) {
            systemBulletin.setSystemId(Integer.parseInt(id));
        }
        if (sysName != null && !sysName.isEmpty()) {
            systemBulletin.setSystemName(sysName);
        }
        if (date != null && !date.isEmpty()) {
            systemBulletin.setSystemDate(date);
        }
        if (adminName != null && !adminName.isEmpty()) {
            systemBulletin.setAdminUserName(adminName);
        }
        if (systemBulletinService.update(systemBulletin)) {
            resp.sendRedirect("list");
        } else {
            req.setAttribute("oldSystemBulletin", systemBulletin);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
    }
}
