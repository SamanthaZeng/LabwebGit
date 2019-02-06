package zxl.web.mapper;

import zxl.web.domain.UserCourse;
import zxl.web.domain.UserCourseKey;

public interface UserCourseMapper {
    int deleteByPrimaryKey(UserCourseKey key);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(UserCourseKey key);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}