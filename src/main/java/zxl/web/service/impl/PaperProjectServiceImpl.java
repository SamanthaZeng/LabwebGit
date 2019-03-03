package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Paper;
import zxl.web.domain.PaperProject;
import zxl.web.domain.PaperProjectKey;
import zxl.web.mapper.PaperMapper;
import zxl.web.mapper.PaperProjectMapper;
import zxl.web.service.IPaperProjectService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PaperProjectServiceImpl implements IPaperProjectService  {
    @Autowired
    PaperProjectMapper mapper;

    @Autowired
    PaperMapper paperMapper;

    @Override
    public List<Paper> selectAssociation(int proid) {
        List<PaperProject> paperProjects = mapper.selectByProid(proid);
        List<Paper> arr = new ArrayList<>();
        if(paperProjects == null)
            return null;
        for(int i=0;i<paperProjects.size();i++)
        {
            arr.add(paperMapper.selectByPrimaryKey(paperProjects.get(i).getPid()));
        }
        return arr;
    }

    @Override
    public int save(PaperProject paperProject) {
        return mapper.insert(paperProject);
    }

    @Override
    public int deleteAssociation(PaperProject paperProject) {
        PaperProjectKey key = new PaperProjectKey(paperProject.getProid(), paperProject.getPid());
        return mapper.deleteByPrimaryKey(key);
    }

}
