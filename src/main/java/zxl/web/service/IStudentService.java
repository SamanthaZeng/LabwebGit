package zxl.web.service;

import zxl.web.domain.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> queryAll();//返回全体学生
    public void delete(Student stu);
    public void save(Student stu);
    public Student queryOne(Student stu);
    public void update(Student stu);
    public Student login(Student stu);
}
