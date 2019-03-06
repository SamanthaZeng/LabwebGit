package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.domain.UserCourse;
import zxl.web.mapper.UserCourseMapper;
import zxl.web.mapper.UserMapper;
import zxl.web.service.IUserCourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseServiceImpl implements IUserCourseService {

    @Autowired
    UserCourseMapper mapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAssociationTeacher(int clsid) {
        List<UserCourse> userCourses = mapper.selectByClsid(clsid);
        List<User> arr = new ArrayList<>();
        if(userCourses == null)
            return null;
        for(int i=0;i<userCourses.size();i++)
        {
            arr.add(userMapper.selectByPrimaryKey(userCourses.get(i).getId()));
        }
        return arr;
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
