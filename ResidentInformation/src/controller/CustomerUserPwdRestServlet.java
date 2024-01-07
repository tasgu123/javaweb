package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/customer/reset"})
public class CustomerUserPwdRestServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("id");
        if (sid != null && !sid.equals("")) {
            customerService.resetPwd(Integer.parseInt(sid));
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('succeed!');" +
                    "window.location.href='home.jsp';</script>')");
        }
        //resp.sendRedirect("list");
        resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                "alert('fail!');" +
                "window.location.href='home.jsp';</script>')");
    }
}
