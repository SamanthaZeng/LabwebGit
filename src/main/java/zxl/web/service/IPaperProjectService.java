package zxl.web.service;

import zxl.web.domain.Paper;
import zxl.web.domain.PaperProject;

import java.util.ArrayList;
import java.util.List;

public interface IPaperProjectService {
    public List<Paper> selectAssociation(int proid);

    public int save(PaperProject paperProject);

    public int deleteAssociation(PaperProject paperProject);
}
