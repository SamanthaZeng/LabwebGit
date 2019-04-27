package zxl.web.service;

import zxl.web.domain.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> queryAll();
    public Course selectCourse(int clsid);
    public void save(Course course);
    public int update(Course course);
    //获取课程id
    public int selectClsid(Course course);
    public void delete(int clsid);
}
