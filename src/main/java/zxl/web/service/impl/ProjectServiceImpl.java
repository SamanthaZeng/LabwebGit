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
}
