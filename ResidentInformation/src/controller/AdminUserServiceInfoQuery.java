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

@WebServlet(urlPatterns = "/admin/serviceInformation/query")
public class AdminUserServiceInfoQuery extends HttpServlet {
    ServiceInformationService serviceInfo = new ServiceInformationImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ServiceInformation serviceInformation = new ServiceInformation();
        serviceInformation.setServiceId(Integer.parseInt(req.getParameter("id")));
        serviceInformation.setServiceName(req.getParameter("name"));
        List<ServiceInformation> servicesInformations = serviceInfo.get(serviceInformation);
        req.setAttribute("serviceInformation", servicesInformations);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
