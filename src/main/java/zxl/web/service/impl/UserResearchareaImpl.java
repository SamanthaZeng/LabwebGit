package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.UserResearchKey;
import zxl.web.mapper.UserResearchMapper;
import zxl.web.service.IUserResearchareaService;

import java.util.List;

@Service
public class UserResearchareaImpl implements IUserResearchareaService {

    @Autowired
    UserResearchMapper mapper;

    @Override
    public void deleteByPrimaryKey(UserResearchKey key) {
        mapper.deleteByPrimaryKey(key);
    }

    @Override
    public void insert(UserResearchKey record) {
        mapper.insert(record);
    }

    @Override
    public List<UserResearchKey> selectResearchare(int id) {
        return mapper.selectResearcharea(id);
    }

    @Override
    public void deleteByUser(int id) {
        mapper.deleteById(id);
    }
}
