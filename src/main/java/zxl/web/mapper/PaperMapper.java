package zxl.web.mapper;

import zxl.web.domain.Paper;

import java.util.Date;
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

    void insertGetId(Paper paper);

    //根据年份返回该年份内的所有paper
    List<Paper> selectPaperbyTime(Date time);
}