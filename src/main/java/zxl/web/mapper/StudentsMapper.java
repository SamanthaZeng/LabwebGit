package zxl.web.mapper;

import zxl.web.domain.Students;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);
}