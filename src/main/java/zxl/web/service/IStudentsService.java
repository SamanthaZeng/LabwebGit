package zxl.web.service;


import zxl.web.domain.Students;
import zxl.web.domain.User;

public interface IStudentsService {
    //注册学生
    public void register(Students stu, User user);
    //获取学生
    public Students select(int sid);
}
