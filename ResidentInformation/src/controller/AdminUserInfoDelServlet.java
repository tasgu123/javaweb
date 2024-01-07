package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceInformationService;
import service.impl.ServiceInformationImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/serviceInformation/del")
public class AdminUserInfoDelServlet extends HttpServlet {
    ServiceInformationService serviceInformation = new ServiceInformationImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty()) {
            serviceInformation.del(Integer.parseInt(id));
        }
        resp.sendRedirect("list");
    }
}
