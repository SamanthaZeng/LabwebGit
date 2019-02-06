package zxl.web.mapper;

import zxl.web.domain.UserResearchKey;

public interface UserResearchMapper {
    int deleteByPrimaryKey(UserResearchKey key);

    int insert(UserResearchKey record);

    int insertSelective(UserResearchKey record);
}