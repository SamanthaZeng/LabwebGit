package zxl.web.mapper;

import zxl.web.domain.UserPro;
import zxl.web.domain.UserProKey;

import java.util.List;

public interface UserProMapper {
    int deleteByPrimaryKey(UserProKey key);

    int insert(UserPro record);

    int insertSelective(UserPro record);

    UserPro selectByPrimaryKey(UserProKey key);

    int updateByPrimaryKeySelective(UserPro record);

    int updateByPrimaryKey(UserPro record);

    //根据项目号返回所有userpro项
    List<UserPro> selectUPs(int proid);
}