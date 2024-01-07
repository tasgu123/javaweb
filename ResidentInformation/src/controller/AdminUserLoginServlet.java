package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminUser;
import service.AdminUserService;
import service.impl.AdminUserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/login"})
public class AdminUserLoginServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从客户端获取用户登录信息
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        AdminUser user = new AdminUser();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        //服务器端输入验证
        if (user.getUsername() == null || user.getPassword() == null || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            //登录失败
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The username or password is blank!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        //验证码输入验证
        String inputCode = req.getParameter("inputCode");
        if (inputCode == null || inputCode.isEmpty()) {
            //登录失败
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
        //调用服务层方法检查是否存在登录用户数据
        AdminUser admin = adminUserService.getLoginUser(user);
        if (admin == null) {
            //登录失败
            resp.getWriter().print("<script language='javascript' charset = \"UTF-8\">" +
                    "alert('The user does not exist!');" +
                    "window.location.href='login.jsp';</script>')");
            return;
        }
        //登录成功
        System.out.println("Servlet 管理员登录成功: " + admin);
        //在会话范围内保存登录用户信息
        session.setAttribute("admin", admin);
        //页面重定向至后台管理平台
        resp.sendRedirect("home.jsp");
    }
}
