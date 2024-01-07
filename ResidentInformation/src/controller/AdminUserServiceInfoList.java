package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ServiceInformation;
import service.ServiceInformationService;
import service.impl.ServiceInformationImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/serviceInformation/list")
public class AdminUserServiceInfoList extends HttpServlet {
    ServiceInformationService serviceInformationService = new ServiceInformationImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<ServiceInformation> list = serviceInformationService.getAll();
        req.setAttribute("serviceInformation", list);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
