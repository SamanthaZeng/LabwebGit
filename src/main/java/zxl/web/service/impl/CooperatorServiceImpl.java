package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Cooperator;
import zxl.web.mapper.CooperatorMapper;
import zxl.web.service.ICooperatorService;

import java.util.List;

@Service
public class CooperatorServiceImpl implements ICooperatorService {

    @Autowired
    CooperatorMapper mapper;
    @Override
    public List<Cooperator> queryAll() {
        return mapper.queryAll();
    }
}
