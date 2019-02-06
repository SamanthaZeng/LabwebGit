package zxl.web.mapper;

import zxl.web.domain.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer clsid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer clsid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}