package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Students;
import zxl.web.domain.User;
import zxl.web.mapper.StudentsMapper;
import zxl.web.mapper.UserMapper;
import zxl.web.service.IStudentsService;

import java.util.List;

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

    @Override
    public Students select(int sid) {
        return mapper.selectByPrimaryKey(sid);
    }

    @Override
    public List<Students> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public int update(Students stu) {
        return mapper.updateByPrimaryKeySelective(stu);
    }

    @Override
    public Students selectStudentById(int id) {
        return mapper.selectStudentById(id);
    }

    @Override
    public List<Students> queryBySrank(int srank) {
        return mapper.queryBySrank(srank);
    }

}
