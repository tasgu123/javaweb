package dao.impl;

import dao.BaseDao;
import dao.CustomerDao;
import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        customer.setResidentId(id);
        List<Customer> customers = query(customer);
        if (customers != null && customers.size() == 1) {
            return customers.get(0);
        }
        return null;
    }

    @Override
    public List<Customer> query(Customer condition) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer_information ";
        if (condition != null) {
            sql += " WHERE 1=1";
            if (condition.getResidentId() != 0) {
                sql += " AND residentId=" + condition.getResidentId();
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
                Customer customer = new Customer();
                customer.setResidentId(rs.getInt("residentId"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setCreateTime(rs.getLong("createTime"));
                customer.setLastAccessTime(rs.getLong("LastAccessTime"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public int insert(Customer customer) {
        int rows;
        String sql = "INSERT INTO customer_information values(?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customer.getResidentId());
            pstmt.setString(2, customer.getUsername());
            pstmt.setString(3, customer.getPassword());
            pstmt.setLong(4, customer.getCreateTime());
            pstmt.setLong(5, customer.getLastAccessTime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(Customer customer) {
        int rows = 0;
        String sql = "UPDATE customer_information SET username=? WHERE residentId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getUsername());
            pstmt.setInt(2, customer.getResidentId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String sql = "DELETE FROM customer_information WHERE residentId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public Customer find(String username, String password) {
        Customer customer = null;
        String sql = "SELECT * FROM customer_information WHERE username=? AND password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setResidentId(rs.getInt("residentId"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setCreateTime(rs.getLong("createTime"));
                customer.setLastAccessTime(rs.getLong("lastAccessTime"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public int updateAccessTime(Customer customer) {
        int rows = 0;
        String sql = "UPDATE customer_information SET lastAccessTime=? WHERE residentId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, customer.getLastAccessTime());
            pstmt.setInt(2, customer.getResidentId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int updatePwd(int id, String newPwd) {
        int rows = 0;
        String sql = "UPDATE customer_information SET password=? WHERE residentId=?";
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
}
