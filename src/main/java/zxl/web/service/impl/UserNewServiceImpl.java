package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.UserNewsKey;
import zxl.web.mapper.UserNewsMapper;
import zxl.web.service.IUserNewsService;

import java.util.List;

@Service
public class UserNewServiceImpl implements IUserNewsService {

    @Autowired
    UserNewsMapper mapper;

    @Override
    public void deleteByPrimaryKey(UserNewsKey key) {
        mapper.deleteByPrimaryKey(key);
    }

    @Override
    public void insert(UserNewsKey record) {
        mapper.insert(record);
    }

    @Override
    public List<UserNewsKey> selectByNewsId(int newsid) {
        return mapper.selectByNewsId(newsid);
    }

    @Override
    public void deleteByNewsId(int newsid) {
        mapper.deleteByNewsId(newsid);
    }
}
