package zxl.web.mapper;

import zxl.web.domain.Student;

import java.util.List;

public interface StudentMapper {

   public List<Student>queryAll();//返回全体学生

    //删除方法
    public void delete(Student stu);

    //保存方法
    public void save(Student stu);

    //查询一条数据
    public Student queryOne(Student stu);

    //更新方法
    public void update(Student stu);

    //登录方法
    public Student login(Student stu);
}
