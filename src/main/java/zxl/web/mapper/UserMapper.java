package zxl.web.mapper;

import zxl.web.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public void register(User user); //注册方法

    public User login(User user);//登录方法

    public List<User> queryAllTeacher();

    public List<User>queryAll();

    public List<String> selectUsername();
}