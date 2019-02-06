package zxl.web.mapper;

import zxl.web.domain.PaperVideoKey;

public interface PaperVideoMapper {
    int deleteByPrimaryKey(PaperVideoKey key);

    int insert(PaperVideoKey record);

    int insertSelective(PaperVideoKey record);
}