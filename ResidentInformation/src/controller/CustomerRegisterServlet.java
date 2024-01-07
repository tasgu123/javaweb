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

@WebServlet(urlPatterns = {"/customer/register"})
public class CustomerRegisterServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Customer customer = new Customer();
        customer.setUsername(req.getParameter("name"));
        customer.setPassword(req.getParameter("password"));
        customerService.register(customer);
        resp.sendRedirect("login.jsp");
    }
}
