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
import java.util.List;

@WebServlet(urlPatterns = "/admin/systemBulletin/list")
public class AdminUserSysListServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<SystemBulletin> systemBulletinList = systemBulletinService.getAll();
        req.setAttribute("systemBulletin", systemBulletinList);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
