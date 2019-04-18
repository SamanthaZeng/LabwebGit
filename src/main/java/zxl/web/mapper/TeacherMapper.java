package zxl.web.mapper;

import zxl.web.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> queryAll();

    //通过用户ID来查找相应的教师
    Teacher selectTeacherById(int id);
}