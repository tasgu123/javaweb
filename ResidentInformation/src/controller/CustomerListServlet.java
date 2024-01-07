package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminUser;
import model.Customer;
import model.Resident;
import service.CustomerService;
import service.ResidentService;
import service.impl.CustomerServiceImpl;
import service.impl.ResidentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/customer/Info/list"})
public class CustomerListServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    ResidentService residentService = new ResidentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        int sid = customer.getResidentId();
        Resident resident = residentService.get(sid);
        HttpSession session = req.getSession();
        session.setAttribute("resident", resident);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
