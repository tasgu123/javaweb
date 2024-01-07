package dao.impl;

import dao.BaseDao;
import dao.ServiceInfoDao;
import model.ServiceInformation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceInfoDaoImpl extends BaseDao implements ServiceInfoDao {
    @Override
    public ServiceInformation findById(int id) {
        ServiceInformation serviceInfo = new ServiceInformation();
        serviceInfo.setServiceId(id);
        List<ServiceInformation> serviceInformations = query(serviceInfo);
        if (serviceInformations != null && serviceInformations.size() == 1) {
            return serviceInformations.get(0);
        }
        return null;
    }

    @Override
    public List<ServiceInformation> query(ServiceInformation condition) {
        List<ServiceInformation> serviceInformations = new ArrayList<>();
        String sql = "SELECT * FROM serviceinfo";
        if (condition != null) {
            sql += " WHERE 1=1";
            if (condition.getServiceId() != 0) {
                sql += " AND serviceId=" + condition.getServiceId();
            }
            if (condition.getServiceName() != null && !condition.getServiceName().isEmpty()) {
                sql += " AND serviceName LIKE '%" + condition.getServiceName() + "%'";
            }
        }
        System.out.println("SQL: " + sql);
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ServiceInformation serviceInformation = new ServiceInformation();
                serviceInformation.setServiceId(rs.getInt("serviceId"));
                serviceInformation.setServiceName(rs.getString("serviceName"));
                serviceInformation.setServiceDate(rs.getString("serviceDate"));
                serviceInformation.setResidentName(rs.getString("residentName"));
                serviceInformations.add(serviceInformation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceInformations;
    }

    @Override
    public int insert(ServiceInformation serviceInformation) {
        int rows;
        String sql = "INSERT INTO serviceinfo values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, serviceInformation.getServiceId());
            pstmt.setString(2, serviceInformation.getServiceName());
            pstmt.setString(3, serviceInformation.getServiceDate());
            pstmt.setString(4, serviceInformation.getResidentName());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(ServiceInformation serviceInformation) {
        int rows;
        String sql = "update serviceinfo set serviceName=?,serviceDate=?,residentName=? where serviceId=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, serviceInformation.getServiceName());
            pstmt.setString(2, serviceInformation.getServiceDate());
            pstmt.setString(3, serviceInformation.getResidentName());
            pstmt.setInt(4, serviceInformation.getServiceId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows;
        String sql = "delete from serviceinfo where serviceId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }
}

