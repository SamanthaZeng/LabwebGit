package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Students;
import zxl.web.domain.User;
import zxl.web.mapper.StudentsMapper;
import zxl.web.mapper.UserMapper;
import zxl.web.service.IStudentsService;

@Service
public class StudentsServiceImpl implements IStudentsService {
    @Autowired
    StudentsMapper mapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void register(Students stu, User user) {
        //将学生相关资料添加到数据库中
        mapper.insertSelective(stu);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
