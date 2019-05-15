package zxl.web.service;


import zxl.web.domain.Students;
import zxl.web.domain.User;

import java.util.List;

public interface IStudentsService {
    //注册学生
    public void register(Students stu, User user);
    //获取学生
    public Students select(int sid);
    //返回全部学生
    public List<Students> queryAll();

    public int update(Students stu);
    //通过用户ID来查找学生
    public Students selectStudentById(int id);
    //通过学生类别来查找学生
    public List<Students>queryBySrank(int srank);
}
