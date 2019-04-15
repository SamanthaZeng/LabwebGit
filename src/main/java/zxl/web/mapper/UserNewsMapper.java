package zxl.web.mapper;

import zxl.web.domain.UserNewsKey;

public interface UserNewsMapper {
    int deleteByPrimaryKey(UserNewsKey key);

    int insert(UserNewsKey record);

    int insertSelective(UserNewsKey record);
}