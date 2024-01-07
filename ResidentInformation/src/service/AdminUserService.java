package service;

import model.AdminUser;

import java.util.List;

public interface AdminUserService {
    //获取指定id的管理员用户
    AdminUser get(int id);

    //查找登录管理员用户
    AdminUser getLoginUser(AdminUser adminUser);

    //获取所有管理员用户
    List<AdminUser> get(AdminUser adminUser);

    //添加管理员用户
    boolean add(AdminUser adminUser);

    //修改管理员用户
    boolean upt(AdminUser adminUser);

    //更新管理员用户最近一次的访问时间
    boolean uptAccessTime(AdminUser adminUser);

    //重置管理员用户登录密码
    boolean resetPwd(int id);

    //删除管理员用户
    boolean del(int id);
}
