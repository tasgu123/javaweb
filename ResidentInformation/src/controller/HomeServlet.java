package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resident;
import service.ResidentService;
import service.impl.ResidentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/residents/list")
public class HomeServlet extends HttpServlet {
    ResidentService residentService = new ResidentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // 处理中文乱码
        List<Resident> residents = residentService.getAll();
        req.setAttribute("residents", residents);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
