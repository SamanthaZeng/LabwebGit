package zxl.web.mapper;

import zxl.web.domain.UserPro;
import zxl.web.domain.UserProKey;

public interface UserProMapper {
    int deleteByPrimaryKey(UserProKey key);

    int insert(UserPro record);

    int insertSelective(UserPro record);

    UserPro selectByPrimaryKey(UserProKey key);

    int updateByPrimaryKeySelective(UserPro record);

    int updateByPrimaryKey(UserPro record);
}