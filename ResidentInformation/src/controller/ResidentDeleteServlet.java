package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ResidentService;
import service.impl.ResidentServiceImpl;

import java.io.IOException;

@WebServlet("/admin/residents/del")
public class ResidentDeleteServlet extends HttpServlet {
    ResidentService residentService = new ResidentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.equals("")) {
            // 调用服务层方法根据客户端传递的id值处理删除图书的业务逻辑
            residentService.del(Integer.parseInt(id));
        }
        // 未获取到id参数，则无法获取图书信息，重定向到图书列表界面
        resp.sendRedirect("list");
    }

}
