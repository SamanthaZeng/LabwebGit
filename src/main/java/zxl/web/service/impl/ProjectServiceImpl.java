package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Project;
import zxl.web.mapper.ProjectMapper;
import zxl.web.service.IProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    ProjectMapper mapper;
    @Override
    public List<Project> queryAll() {
        return mapper.queryAll();
    }
    @Override
    public Project selectProject(int proid) { return mapper.selectByPrimaryKey(proid); }

    @Override
    public void save(Project project) {
        mapper.insertGetId(project);
    }

    @Override
    public int update(Project project) {
        return mapper.updateByPrimaryKey(project);
    }

    @Override
    public int selectProid(Project project) {
        return mapper.selectProid(project);
    }

    @Override
    public void delete(int proid) {
        mapper.deleteByPrimaryKey(proid);
    }

    @Override
    public List<Project> queryByType(int protype) {
        return mapper.queryByType(protype);
    }

    ;
}
