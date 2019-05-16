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

    @Override
    public void delete(int rid) {
        mapper.deleteByPrimaryKey(rid);
    }

    @Override
    public Researcharea selectResearcharea(int rid) {
        return mapper.selectByPrimaryKey(rid);
    }

    @Override
    public void insert(Researcharea researcharea) {
        mapper.insertSelective(researcharea);
    }

    @Override
    public void update(Researcharea researcharea) {
        mapper.updateByPrimaryKeySelective(researcharea);
    }

    @Override
    public Researcharea queryinfo() {
        return mapper.queryinfo();
    }
}
