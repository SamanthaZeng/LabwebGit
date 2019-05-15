package zxl.web.mapper;

import zxl.web.domain.Student;
import zxl.web.domain.Students;

import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> queryAll();

    Students selectStudentById(int id);

    List<Students>queryBySrank(int srank);
}