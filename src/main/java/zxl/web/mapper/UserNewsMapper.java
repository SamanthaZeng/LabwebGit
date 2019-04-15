package zxl.web.mapper;

import zxl.web.domain.UserNewsKey;

import java.util.List;

public interface UserNewsMapper {
    int deleteByPrimaryKey(UserNewsKey key);

    int insert(UserNewsKey record);

    int insertSelective(UserNewsKey record);

    List<UserNewsKey> selectByNewsId(int newsid);

    int deleteByNewsId(int newsid);
}