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

@WebServlet(urlPatterns = {"/customer/mod"})
public class CustomerModServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Customer customer = new Customer();
        customer.setResidentId(Integer.parseInt(req.getParameter("id")));
        customer.setUsername(req.getParameter("username"));
        customer.setPassword(req.getParameter("password"));
        customer.setCreateTime(Long.parseLong(req.getParameter("createTime")));
        customer.setCreateTime(Long.parseLong(req.getParameter("lastAccessTime")));
        if (customerService.upt(customer)) {
            resp.sendRedirect("Info/list");
        } else {
            req.setAttribute("oldCustomer", customer);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
    }
}
