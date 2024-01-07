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

@WebServlet(urlPatterns = {"/customer/Info/modPre"})
public class CustomerInfoModPreServlet extends HttpServlet {
    ResidentService residentService = new ResidentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String residentId = req.getParameter("id");
        if (residentId != null && !residentId.equals("")) {
            Resident resident = residentService.get(Integer.parseInt(residentId));
            req.setAttribute("oldResident", resident);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
        resp.sendRedirect("list");
    }
}
