package zxl.web.mapper;

import zxl.web.domain.UserBook;
import zxl.web.domain.UserBookKey;

public interface UserBookMapper {
    int deleteByPrimaryKey(UserBookKey key);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(UserBookKey key);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
}