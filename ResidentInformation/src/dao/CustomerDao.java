package dao;

import dao.SimpleDao;
import model.AdminUser;
import model.Customer;

public interface CustomerDao extends SimpleDao<Customer> {
    Customer find(String name, String password);

    int updateAccessTime(Customer adminUser);

    int updatePwd(int id, String newPwd);
}
