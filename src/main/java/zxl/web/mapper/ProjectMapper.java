package zxl.web.mapper;

import zxl.web.domain.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer proid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer proid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}