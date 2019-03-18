package zxl.web.mapper;

import zxl.web.domain.UserPaper;
import zxl.web.domain.UserPaperKey;

import java.util.List;

public interface UserPaperMapper {
    int deleteByPrimaryKey(UserPaperKey key);

    int insert(UserPaper record);

    int insertSelective(UserPaper record);

    UserPaper selectByPrimaryKey(UserPaperKey key);

    int updateByPrimaryKeySelective(UserPaper record);

    int updateByPrimaryKey(UserPaper record);

    List<UserPaper> selectByPid(int pid);
}