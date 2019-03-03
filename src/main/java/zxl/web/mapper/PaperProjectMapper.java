package zxl.web.mapper;

import zxl.web.domain.Paper;
import zxl.web.domain.PaperProject;
import zxl.web.domain.PaperProjectKey;

import java.util.List;

public interface PaperProjectMapper {
    int deleteByPrimaryKey(PaperProjectKey key);

    int insert(PaperProject record);

    int insertSelective(PaperProject record);

    PaperProject selectByPrimaryKey(PaperProjectKey key);

    int updateByPrimaryKeySelective(PaperProject record);

    int updateByPrimaryKey(PaperProject record);

    List<PaperProject> selectByProid(int proid);
}