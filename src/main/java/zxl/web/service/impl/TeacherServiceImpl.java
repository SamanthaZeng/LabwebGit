package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Students;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.mapper.TeacherMapper;
import zxl.web.mapper.UserMapper;
import zxl.web.service.ITeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper mapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void register(Teacher teacher, User user) {
        mapper.insertSelective(teacher);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Teacher select(int tid) {
       return mapper.selectByPrimaryKey(tid);
    }

    @Override
    public List<Teacher> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public int update(Teacher teacher) {
        return mapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public Teacher selectTeacherById(int id) {
        return mapper.selectTeacherById(id);
    }
}
