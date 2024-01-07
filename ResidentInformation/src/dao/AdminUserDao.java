package dao;

import model.AdminUser;

public interface AdminUserDao extends SimpleDao<AdminUser> {
    AdminUser find(String name, String password);
    int updateAccessTime(AdminUser adminUser);
    int updatePwd(int id, String newPwd);
}
