package zxl.web.mapper;

import zxl.web.domain.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}