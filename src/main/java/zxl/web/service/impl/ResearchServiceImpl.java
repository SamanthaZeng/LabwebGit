package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Researcharea;
import zxl.web.mapper.ResearchareaMapper;
import zxl.web.service.IResearchService;

@Service
public class ResearchServiceImpl implements IResearchService {
@Autowired
    ResearchareaMapper mapper;
    @Override
    public Researcharea selectResearch(int rid) {
        return mapper.selectByPrimaryKey(rid);
    }
}
