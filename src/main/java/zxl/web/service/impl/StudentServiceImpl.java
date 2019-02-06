package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Student;
import zxl.web.mapper.StudentMapper;
import zxl.web.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper mapper;

    @Override
    public List<Student> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public void delete(Student stu) {
        mapper.delete(stu);
    }

    @Override
    public void save(Student stu) {
        mapper.save(stu);
    }

    @Override
    public Student queryOne(Student stu) {
        return mapper.queryOne(stu);
    }

    @Override
    public void update(Student stu) {
        mapper.update(stu);
    }

    @Override
    public Student login(Student stu) {
        return mapper.login(stu);
    }

}
