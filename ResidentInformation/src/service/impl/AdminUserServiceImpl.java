package service.impl;

import dao.AdminUserDao;
import dao.impl.AdminUserDaoImpl;
import model.AdminUser;
import service.AdminUserService;
import util.Encrypt;

import java.util.Date;
import java.util.List;

public class AdminUserServiceImpl implements AdminUserService {
    AdminUserDao adminUserDao = new AdminUserDaoImpl();

    @Override
    public AdminUser get(int id) {
        return adminUserDao.findById(id);
    }

    @Override
    public AdminUser getLoginUser(AdminUser adminUser) {
        if (adminUser == null) {
            return null;
        }
        adminUser.setPassword(Encrypt.toMd5(adminUser.getPassword()));
        AdminUser user = adminUserDao.find(adminUser.getUsername(), adminUser.getPassword());
        if (user != null) {
            user.setLastAccessTime(new Date());
            adminUserDao.updateAccessTime(user);
        }
        return user;
    }

    @Override
    public List<AdminUser> get(AdminUser adminUser) {
        return adminUserDao.query(null);
    }

    @Override
    public boolean add(AdminUser adminUser) {
        adminUser.setPassword(Encrypt.toMd5(adminUser.getPassword()));
        return adminUserDao.insert(adminUser) == 1;
    }

    @Override
    public boolean upt(AdminUser adminUser) {
        return adminUserDao.update(adminUser) == 1;
    }

    @Override
    public boolean uptAccessTime(AdminUser adminUser) {
        adminUser.setLastAccessTime(new Date().getTime());
        return adminUserDao.updateAccessTime(adminUser) == 1;
    }

    @Override
    public boolean resetPwd(int id) {
        String newPassword = Encrypt.toMd5("123");
        return adminUserDao.updatePwd(id, newPassword) == 1;
    }

    @Override
    public boolean del(int id) {
        return adminUserDao.delete(id) == 1;
    }
}
