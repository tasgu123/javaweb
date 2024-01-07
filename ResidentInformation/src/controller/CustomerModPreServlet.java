package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/customer/modPre"})
public class CustomerModPreServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String residentId = req.getParameter("id");
        if (residentId != null && !residentId.equals("")) {
            Customer customer = customerService.get(Integer.parseInt(residentId));
            req.setAttribute("oldCustomer", customer);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
        resp.sendRedirect("Info/list");
    }
}
