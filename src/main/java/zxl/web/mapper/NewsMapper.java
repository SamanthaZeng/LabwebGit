package zxl.web.mapper;

import zxl.web.domain.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> queryAll();
}