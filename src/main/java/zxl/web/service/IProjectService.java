package zxl.web.service;

import zxl.web.domain.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> queryAll();
    public Project selectProject(int proid);
    public void save(Project project);
    public int update(Project project);
    //返回项目id
    public int selectProid(Project project);
    public void delete(int proid);
    //根据项目类型返回项目
    public List<Project>queryByType(int protype);
}
