package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.User;
import zxl.web.mapper.UserMapper;
import zxl.web.service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper mapper;
    @Override
    public void register(User user) {
        mapper.register(user);
    }

    @Override
    public User selectuser(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(User user) {
        return mapper.login(user);
    }

    @Override
    public List<User> queryAllTeacher() {
        return mapper.queryAllTeacher();
    }

    @Override
    public int deleteUser(int id)
    {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }
}
