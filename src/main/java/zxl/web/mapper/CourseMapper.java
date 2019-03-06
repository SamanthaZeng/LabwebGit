package zxl.web.mapper;

import zxl.web.domain.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer clsid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer clsid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> queryAll();

    List<Course> selectCourseId(Course course);
}