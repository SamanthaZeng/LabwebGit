package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.ProResearchKey;
import zxl.web.mapper.ProResearchMapper;
import zxl.web.service.IProResearchService;

import java.util.List;

@Service
public class ProResearchImpl implements IProResearchService {
    @Autowired
    ProResearchMapper mapper;

    @Override
    public List<ProResearchKey> findByRid(int rid) {
        return mapper.findByRid(rid);
    }
}
