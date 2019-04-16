package zxl.web.service;

import zxl.web.domain.User;

import java.util.List;

public interface IUserService {
    public void register(User user);//注册方法

    public User selectuser(int id);//返回user对象

    public  User login(User user);//用户登陆

    public List<User>queryAllTeacher();//返回所有教师用户

    public List<User>queryAll();//返回所有用户
    
    public int deleteUser(int id);

    public int update(User user);

    public List<String> selectUsername();
}
