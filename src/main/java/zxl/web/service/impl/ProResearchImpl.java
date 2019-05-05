package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.ProResearchKey;
import zxl.web.domain.Researcharea;
import zxl.web.mapper.ProResearchMapper;
import zxl.web.service.IProResearchService;
import zxl.web.service.IProjectService;
import zxl.web.service.IResearchareaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProResearchImpl implements IProResearchService {
    @Autowired
    ProResearchMapper mapper;

    @Autowired
    IResearchareaService researchareaService;

    @Override
    public List<ProResearchKey> findByRid(int rid) {
        return mapper.findByRid(rid);
    }

    @Override
    public List<Researcharea> findByProid(int proid) {
        List<ProResearchKey> proResearchKeyList = mapper.findByProid(proid);
        List<Researcharea> researchareaList = new ArrayList<>();
        for(int i=0;i<proResearchKeyList.size();i++) {
            researchareaList.add(researchareaService.selectResearcharea(proResearchKeyList.get(i).getRid()));
        }
        return researchareaList;
    }

    @Override
    public void insert(ProResearchKey proResearchKey) {
        mapper.insert(proResearchKey);
    }

    @Override
    public void deleteByProid(int proid) {
        mapper.deleteByProid(proid);
    }
}
