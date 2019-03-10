package zxl.web.mapper;

import zxl.web.domain.UserBook;
import zxl.web.domain.UserBookKey;

import java.util.List;

public interface UserBookMapper {
    int deleteByPrimaryKey(UserBookKey key);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(UserBookKey key);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);

    List<UserBook> selectUBs(int bid);
}