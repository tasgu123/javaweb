package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminUserService;
import service.impl.AdminUserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/adminUsers/reset"})
public class AdminUserPwdResetServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("id");
        if (sid != null && !sid.equals("")) {
            adminUserService.resetPwd(Integer.parseInt(sid));
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('succeed!');" +
                    "window.location.href='list';</script>')");
        }
        //resp.sendRedirect("list");
        resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                "alert('fail!');" +
                "window.location.href='list';</script>')");
    }
}
