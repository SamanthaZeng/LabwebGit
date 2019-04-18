package zxl.web.mapper;

import zxl.web.domain.UserResearchKey;

import java.util.List;

public interface UserResearchMapper {
    int deleteByPrimaryKey(UserResearchKey key);

    int insert(UserResearchKey record);

    int insertSelective(UserResearchKey record);

    List<UserResearchKey> selectResearcharea(int id);

    int deleteById(int id);

    List<UserResearchKey>  queryAll(int rid);
}