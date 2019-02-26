package zxl.web.service;

import zxl.web.domain.User;

public interface IUserService {
    public void register(User user);//注册方法

    public User selectuser(int id);//返回user对象

    public  User login(User user);//用户登陆
}
