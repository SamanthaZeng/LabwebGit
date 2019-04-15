package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Researcharea;
import zxl.web.mapper.ResearchareaMapper;
import zxl.web.service.IResearchareaService;

import java.util.List;
@Service
public class ResearchareaServiceImpl implements IResearchareaService {
    @Autowired
    ResearchareaMapper mapper;

    @Override
    public List<Researcharea> queryAll() {
        return mapper.queryAll();
    }
}
