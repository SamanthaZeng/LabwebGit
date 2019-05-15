package zxl.web.mapper;

import zxl.web.domain.User;
import zxl.web.domain.UserCourse;
import zxl.web.domain.UserCourseKey;

import java.util.List;

public interface UserCourseMapper {
    int deleteByPrimaryKey(UserCourseKey key);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(UserCourseKey key);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);

    List<UserCourse> selectByClsid(int clsid);

    List<UserCourse>selectUCls(int clsid);

    List<UserCourse>selectCidByid(int id);
}