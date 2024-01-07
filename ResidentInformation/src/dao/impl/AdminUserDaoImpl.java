package dao.impl;

import dao.AdminUserDao;
import dao.BaseDao;
import model.AdminUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminUserDaoImpl extends BaseDao implements AdminUserDao {
    @Override
    public AdminUser find(String username, String password) {
        AdminUser adminUser = null;
        String sql = "SELECT * FROM admin_information WHERE username=? AND password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                adminUser = new AdminUser();
                adminUser.setId(rs.getInt("id"));
                adminUser.setUsername(rs.getString("username"));
                adminUser.setPassword(rs.getString("password"));
                adminUser.setCreateTime(rs.getLong("createTime"));
                adminUser.setLastAccessTime(rs.getLong("lastAccessTime"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminUser;
    }

    @Override
    public int updateAccessTime(AdminUser adminUser) {
        int rows = 0;
        String sql = "UPDATE admin_information SET lastAccessTime=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, adminUser.getLastAccessTime());
            pstmt.setInt(2, adminUser.getId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int updatePwd(int id, String newPwd) {
        int rows = 0;
        String sql = "UPDATE admin_information SET password=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPwd);
            pstmt.setInt(2, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public AdminUser findById(int id) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(id);
        List<AdminUser> adminUsers = query(adminUser);
        if (adminUsers != null && adminUsers.size() == 1) {
            return adminUsers.get(0);
        }
        return null;
    }

    @Override
    public List<AdminUser> query(AdminUser condition) {
        List<AdminUser> adminUsers = new ArrayList<>();
        String sql = "SELECT * FROM admin_information ";
        if (condition != null) {
            sql += " WHERE 1=1";
            if (condition.getId() != 0) {
                sql += " AND id=" + condition.getId();
            }
            if (condition.getUsername() != null && !condition.getUsername().isEmpty()) {
                sql += " AND username LIKE '%" + condition.getUsername() + "%'";
            }
        }
        System.out.println("SQL: " + sql);
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AdminUser adminUser = new AdminUser();
                adminUser.setId(rs.getInt("id"));
                adminUser.setUsername(rs.getString("username"));
                adminUser.setPassword(rs.getString("password"));
                adminUser.setCreateTime(rs.getLong("createTime"));
                adminUser.setLastAccessTime(rs.getLong("LastAccessTime"));
                adminUsers.add(adminUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminUsers;
    }

    @Override
    public int insert(AdminUser adminUser) {
        int rows;
        String sql = "INSERT INTO admin_information values(?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, adminUser.getId());
            pstmt.setString(2, adminUser.getUsername());
            pstmt.setString(3, adminUser.getPassword());
            pstmt.setLong(4, adminUser.getCreateTime());
            pstmt.setLong(5, adminUser.getLastAccessTime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(AdminUser adminUser) {
        int rows = 0;
        String sql = "UPDATE admin_information SET username=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminUser.getUsername());
            pstmt.setInt(2, adminUser.getId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String sql = "DELETE FROM admin_information WHERE id=?";
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
