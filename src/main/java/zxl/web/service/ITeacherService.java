package zxl.web.service;

import zxl.web.domain.Students;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;

public interface ITeacherService {
    //教师注册
    public void register(Teacher teache, User user);
    //获取教师
    public Teacher select(int tid);
}