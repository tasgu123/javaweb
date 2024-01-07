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

@WebServlet("/admin/residents/uptPro")

public class ResidentUpdateProServlet extends HttpServlet {
    ResidentService service = new ResidentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.equals("")) {
            Resident resident = service.get(Integer.parseInt(id));
            req.setAttribute("residents", resident);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("list");
        }
    }
}
