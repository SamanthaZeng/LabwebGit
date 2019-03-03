package zxl.web.service;

import zxl.web.domain.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> queryAll();
    public Project selectProject(int proid);
    public int save(Project project);
    public int update(Project project);
}
