package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.domain.UserCourse;
import zxl.web.mapper.UserCourseMapper;
import zxl.web.service.IUserCourseService;

import java.util.List;

@Service
public class UserCourseServiceImpl implements IUserCourseService {

    @Autowired
    UserCourseMapper mapper;

    @Override
    public List<User> selectAssociationTeacher(int clsid) {
        return mapper.selectByClsid(clsid);
    }

    @Override
    public int deleteAssociation(UserCourse userCourse) {
        return mapper.deleteByPrimaryKey(userCourse);
    }

    @Override
    public int save(UserCourse userCourse) {
        return mapper.insert(userCourse);
    }
}
