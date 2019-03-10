package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Cooperator;
import zxl.web.domain.User;
import zxl.web.mapper.CooperatorMapper;
import zxl.web.mapper.UserMapper;
import zxl.web.service.ICooperatorService;

import java.util.List;

@Service
public class CooperatorServiceImpl implements ICooperatorService {

    @Autowired
    CooperatorMapper mapper;

    @Autowired
    UserMapper userMapper;
    @Override
    public List<Cooperator> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public Cooperator select(int cid) {
        return mapper.selectByPrimaryKey(cid);
    }

    @Override
    public void register(Cooperator cooperator, User user) {
        mapper.insertSelective(cooperator);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int update(Cooperator cooperator) {
        return mapper.updateByPrimaryKeySelective(cooperator);
    }

}
