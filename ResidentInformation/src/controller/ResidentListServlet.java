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

@WebServlet("/admin/residents/query")
public class ResidentListServlet extends HttpServlet {
    ResidentService service = new ResidentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Resident resident = new Resident();
        resident.setResidentId(Integer.parseInt(req.getParameter("id")));
        resident.setName(req.getParameter("name"));
        List<Resident> residents = service.get(resident);
        req.setAttribute("residents", residents);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
