package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;
import util.Encrypt;

import java.util.Date;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer getLoginUser(Customer customer) {
        if (customer == null) {
            return null;
        }
        customer.setPassword(Encrypt.toMd5(customer.getPassword()));
        Customer user = customerDao.find(customer.getUsername(), customer.getPassword());
        if (user != null) {
            user.setLastAccessTime(new Date());
            customerDao.updateAccessTime(user);
        }
        return user;
    }

    @Override
    public boolean upt(Customer customer) {
        return customerDao.update(customer) == 1;
    }

    @Override
    public boolean uptAccessTime(Customer customer) {
        customer.setLastAccessTime(new Date().getTime());
        return customerDao.updateAccessTime(customer) == 1;
    }

    @Override
    public boolean resetPwd(int id) {
        String sid = Encrypt.toMd5("123");
        return customerDao.updatePwd(id, sid) == 1;

    }

    @Override
    public boolean del(int id) {
        return customerDao.delete(id) == 1;
    }

    @Override
    public boolean register(Customer customer) {
        customer.setPassword(Encrypt.toMd5(customer.getPassword()));
        return customerDao.insert(customer) == 1;
    }

    @Override
    public Customer get(int id) {
        return customerDao.findById(id);
    }
}
