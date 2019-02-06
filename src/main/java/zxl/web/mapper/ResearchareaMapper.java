package zxl.web.mapper;

import zxl.web.domain.Researcharea;

public interface ResearchareaMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Researcharea record);

    int insertSelective(Researcharea record);

    Researcharea selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Researcharea record);

    int updateByPrimaryKey(Researcharea record);
}