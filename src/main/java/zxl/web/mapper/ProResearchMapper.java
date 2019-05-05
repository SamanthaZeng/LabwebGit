package zxl.web.mapper;

import zxl.web.domain.ProResearchKey;

import java.util.List;

public interface ProResearchMapper {
    int deleteByPrimaryKey(ProResearchKey key);

    int insert(ProResearchKey record);

    int insertSelective(ProResearchKey record);

    List<ProResearchKey> findByRid(int rid);

    List<ProResearchKey> findByProid(int proid);

    int deleteByProid(int proid);
}