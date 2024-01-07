package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminUser;
import model.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/customer/login"})
public class CustomerLoginServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Customer customer = new Customer();
        customer.setUsername(req.getParameter("username"));
        customer.setPassword(req.getParameter("password"));
        if (customer.getUsername() == null || customer.getPassword() == null || customer.getUsername().isEmpty() || customer.getPassword().isEmpty()) {
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The username or password is blank!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        String inputCode = req.getParameter("inputCode");
        if (inputCode == null || inputCode.isEmpty()) {
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The verification code is empty!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        //获取会话对象
        HttpSession session = req.getSession();
        //验证验证码
        String validCode = (String) session.getAttribute("validCode");
        if (!inputCode.equalsIgnoreCase(validCode)) {
            //登录失败
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The verification code is incorrect!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        Customer user = customerService.getLoginUser(customer);
        if (user == null) {
            //登录失败
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The user does not exist!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        //登录成功
        System.out.println("Servlet 顾客登录成功: " + user);
        //在会话范围内保存登录用户信息
        session.setAttribute("customer", user);
        //页面重定向至后台管理平台
        resp.sendRedirect("home.jsp");
    }
}
