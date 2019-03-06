package zxl.web.service;

import zxl.web.domain.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> queryAll();
    public Course selectCourse(int clsid);
    public int save(Course course);
    public int update(Course course);
    public List<Course> selectCourseId(Course course);
}
