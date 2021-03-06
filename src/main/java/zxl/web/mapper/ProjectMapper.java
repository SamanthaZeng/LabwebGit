package zxl.web.mapper;

import zxl.web.domain.Project;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer proid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer proid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> queryAll();

    //返回proid
    int selectProid(Project project);

    void insertGetId(Project project);

    List<Project>queryByType(int protype);
}