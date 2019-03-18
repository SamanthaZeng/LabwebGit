package zxl.web.service;

import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.domain.UserCourse;
import zxl.web.domain.UserCourseKey;

import java.util.List;

public interface IUserCourseService {
    public List<User> selectAssociationTeacher(int clsid);

    public int deleteAssociation(UserCourse userCourse);

    public int save(UserCourse userCourse);

    //获取所有该clsid的USERCOURSE项
    public List<UserCourse>selectUCls(int clsid);

    //删除含有该clsid的所有制
    public void deleteClsid(UserCourseKey userCourseKey);

    //添加新项
    public void insert(UserCourse userCourse);
}
