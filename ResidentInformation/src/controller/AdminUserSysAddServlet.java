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

@WebServlet(urlPatterns = "/admin/systemBulletin/add")
public class AdminUserSysAddServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        SystemBulletin systemBulletin = new SystemBulletin();
        systemBulletin.setSystemId(Integer.parseInt(req.getParameter("id")));
        systemBulletin.setSystemName(req.getParameter("name"));
        systemBulletin.setSystemDate(req.getParameter("date"));
        systemBulletin.setAdminUserName(req.getParameter("adminName"));
        systemBulletinService.add(systemBulletin);
        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
