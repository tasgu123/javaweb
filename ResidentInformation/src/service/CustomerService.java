package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    //获取当前住户
    Customer getLoginUser(Customer customer);

    //修改住户信息
    boolean upt(Customer customer);

    //更新住户最近一次的访问时间
    boolean uptAccessTime(Customer customer);

    //重置住户登录密码
    boolean resetPwd(int id);

    //注销住户
    boolean del(int id);

    //注册新用户
    boolean register(Customer customer);

    Customer get(int id);
}
