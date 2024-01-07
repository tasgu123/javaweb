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

@WebServlet(urlPatterns = {"/customer/serviceInformation/add"})
public class CustomerServiceInfoAddServlet extends HttpServlet {
    ServiceInformationService service = new ServiceInformationImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ServiceInformation serviceInformation = new ServiceInformation();
        serviceInformation.setServiceId(Integer.parseInt(req.getParameter("id")));
        serviceInformation.setServiceName(req.getParameter("name"));
        serviceInformation.setServiceDate(req.getParameter("date"));
        serviceInformation.setResidentName(req.getParameter("residentName"));
        service.add(serviceInformation);
        resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                "alert('succeed!');" +
                "window.location.href='add.jsp';</script>')");
    }
}
