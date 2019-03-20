package zxl.web.mapper;

import zxl.web.domain.Paper;

import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> queryAll();

    //返回paperid
    int selectPid(Paper paper);
}