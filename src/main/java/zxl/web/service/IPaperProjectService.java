package zxl.web.service;

import zxl.web.domain.Paper;
import zxl.web.domain.PaperProject;
import zxl.web.domain.Project;

import java.util.ArrayList;
import java.util.List;

public interface IPaperProjectService {
    public List<Paper> selectAssociation(int proid);

    public List<Project> selectAssociationProject(int pid);

    public int save(PaperProject paperProject);

    public int deleteAssociation(PaperProject paperProject);
}
