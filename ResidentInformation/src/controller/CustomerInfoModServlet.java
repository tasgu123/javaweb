package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resident;
import service.ResidentService;
import service.impl.ResidentServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/customer/Info/mod"})
public class CustomerInfoModServlet extends HttpServlet {
    ResidentService residentService = new ResidentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String telephone = req.getParameter("telephone");
        String buildingNo = req.getParameter("buildingNo");
        String houseNumber = req.getParameter("houseNumber");
        Resident resident = new Resident();
        if (id != 0) {
            resident.setResidentId(id);
        }
        if (name != null && !name.equals("")) {
            resident.setName(name);
        }
        if (gender != null && !gender.equals("")) {
            resident.setGender(gender);
        }
        if (telephone != null && !telephone.equals("")) {
            resident.setTelephone(telephone);
        }
        if (buildingNo != null && !buildingNo.equals("")) {
            resident.setBuildingNo(buildingNo);
        }
        if (houseNumber != null && !houseNumber.equals("")) {
            resident.setHouseNumber(houseNumber);
        }
        if (residentService.update(resident)) {
            resp.sendRedirect("list");
        } else {
            req.setAttribute("oldResident", resident);
            req.getRequestDispatcher("mod.jsp").forward(req, resp);
        }
    }
}
