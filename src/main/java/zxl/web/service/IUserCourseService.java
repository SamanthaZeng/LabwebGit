package zxl.web.service;

import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.domain.UserCourse;

import java.util.List;

public interface IUserCourseService {
    public List<User> selectAssociationTeacher(int clsid);

    public int deleteAssociation(UserCourse userCourse);

    public int save(UserCourse userCourse);
}
