package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Course;
import zxl.web.mapper.CourseMapper;
import zxl.web.service.ICourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    CourseMapper mapper;

    @Override
    public List<Course> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public Course selectCourse(int clsid) {
        return mapper.selectByPrimaryKey(clsid);
    }

    @Override
    public int save(Course course) {
        return mapper.insert(course);
    }

    @Override
    public int update(Course course) {
        return mapper.updateByPrimaryKey(course);
    }

    @Override
    public List<Course> selectCourseId(Course course) {
        return mapper.selectCourseId(course);
    }
}
