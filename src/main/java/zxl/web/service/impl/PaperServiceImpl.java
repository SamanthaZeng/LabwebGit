package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Paper;
import zxl.web.mapper.PaperMapper;
import zxl.web.service.ICooperatorService;
import zxl.web.service.IPaperService;

import java.util.Date;
import java.util.List;

@Service
public class PaperServiceImpl implements IPaperService {
    @Autowired
    PaperMapper mapper;

    @Override
    public List<Paper> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public Paper selectPaper(int pid) {
        return mapper.selectByPrimaryKey(pid);
    }

    @Override
    public int update(Paper paper) { return mapper.updateByPrimaryKey(paper);}

    @Override
    public int save(Paper paper) { return mapper.insert(paper);}

    @Override
    public int selectPid(Paper paper) {
        return mapper.selectPid(paper);
    }

    @Override
    public void deleteByPid(int pid) {
        mapper.deleteByPrimaryKey(pid);
    }

    @Override
    public List<Paper> selectPaperbyTime(Date time) {
        return mapper.selectPaperbyTime(time);
    }
}
