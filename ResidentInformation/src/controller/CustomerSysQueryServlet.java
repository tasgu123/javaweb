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

@WebServlet(urlPatterns = {"/customer/systemBulletin/query"})
public class CustomerSysQueryServlet extends HttpServlet {
    SystemBulletinService systemBulletinService = new SystemBulletinServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        SystemBulletin systemBulletin = new SystemBulletin();
        systemBulletin.setSystemId(Integer.parseInt(req.getParameter("id")));
        systemBulletin.setSystemName(req.getParameter("name"));
        List<SystemBulletin> systemBulletList = systemBulletinService.get(systemBulletin);
        req.setAttribute("systemBulletin", systemBulletList);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
