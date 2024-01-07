package dao.impl;

import dao.BaseDao;
import dao.ResidentDao;
import model.Resident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidentDaoImpl extends BaseDao implements ResidentDao {
    @Override
    public Resident findById(int id) {
        Resident resident = new Resident();
        resident.setResidentId(id);
        List<Resident> residents = query(resident);
        if (residents != null && residents.size() == 1) {
            return residents.get(0);
        }
        return null;
    }

    @Override
    public List<Resident> query(Resident condition) {
        List<Resident> residents = new ArrayList<>();
        String sql = "SELECT * FROM resident_information";
        if (condition != null) {
            sql += " WHERE 1=1";
            if (condition.getResidentId() != 0) {
                sql += " AND residentId=" + condition.getResidentId();
            }
            if (condition.getName() != null && !condition.getName().isEmpty()) {
                sql += " AND name LIKE '%" + condition.getName() + "%'";
            }
        }
        System.out.println("SQL: " + sql);
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Resident resident = new Resident();
                resident.setResidentId(rs.getInt("residentId"));
                resident.setName(rs.getString("name"));
                resident.setGender(rs.getString("gender"));
                resident.setTelephone(rs.getString("telephone"));
                resident.setBuildingNo(rs.getString("buildingNo"));
                resident.setHouseNumber(rs.getString("houseNumber"));
                residents.add(resident);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return residents;
    }

    @Override
    public int insert(Resident resident) {
        int rows;
        String sql = "INSERT INTO resident_information values(?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, resident.getResidentId());
            pstmt.setString(2, resident.getName());
            pstmt.setString(3, resident.getGender());
            pstmt.setString(4, resident.getTelephone());
            pstmt.setString(5, resident.getBuildingNo());
            pstmt.setString(6, resident.getHouseNumber());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(Resident resident) {
        int rows;
        String sql = "update resident_information set name=?,gender=?,telephone=?,buildingNo=?,houseNumber=? where residentId=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, resident.getName());
            pstmt.setString(2, resident.getGender());
            pstmt.setString(3, resident.getTelephone());
            pstmt.setString(4, resident.getBuildingNo());
            pstmt.setString(5, resident.getHouseNumber());
            pstmt.setInt(6, resident.getResidentId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows;
        String sql = "delete from resident_information where residentId=?";
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
