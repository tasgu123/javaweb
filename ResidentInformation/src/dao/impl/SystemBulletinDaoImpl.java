package dao.impl;

import dao.BaseDao;
import dao.SystemBulletinDao;
import model.SystemBulletin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SystemBulletinDaoImpl extends BaseDao implements SystemBulletinDao {
    @Override
    public SystemBulletin findById(int id) {
        SystemBulletin systemBulletin = new SystemBulletin();
        systemBulletin.setSystemId(id);
        List<SystemBulletin> systemBulletins = query(systemBulletin);
        if (systemBulletins != null && systemBulletins.size() == 1) {
            return systemBulletins.get(0);
        }
        return null;
    }

    @Override
    public List<SystemBulletin> query(SystemBulletin condition) {
        List<SystemBulletin> systemBulletins = new ArrayList<>();
        String sql = "SELECT * FROM systembulletin";
        if (condition != null) {
            sql += " WHERE 1=1";
            if (condition.getSystemId() != 0) {
                sql += " AND systemId=" + condition.getSystemId();
            }
            if (condition.getSystemName() != null && !condition.getSystemName().isEmpty()) {
                sql += " AND systemName LIKE '%" + condition.getSystemName() + "%'";
            }
        }
        System.out.println("SQL: " + sql);
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SystemBulletin systemBulletin = new SystemBulletin();
                systemBulletin.setSystemId(rs.getInt("systemId"));
                systemBulletin.setSystemName(rs.getString("systemName"));
                systemBulletin.setSystemDate(rs.getString("systemDate"));
                systemBulletin.setAdminUserName(rs.getString("adminUserName"));
                systemBulletins.add(systemBulletin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return systemBulletins;
    }

    @Override
    public int insert(SystemBulletin systemBulletin) {
        int rows;
        String sql = "INSERT INTO systembulletin values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, systemBulletin.getSystemId());
            pstmt.setString(2, systemBulletin.getSystemName());
            pstmt.setString(3, systemBulletin.getSystemDate());
            pstmt.setString(4, systemBulletin.getAdminUserName());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(SystemBulletin systemBulletin) {
        int rows;
        String sql = "update systembulletin set systemName=?,systemDate=?,adminUserName=? where systemId=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, systemBulletin.getSystemName());
            pstmt.setString(2, systemBulletin.getSystemDate());
            pstmt.setString(3, systemBulletin.getAdminUserName());
            pstmt.setInt(4, systemBulletin.getSystemId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows;
        String sql = "delete from systembulletin where systemId=?";
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
