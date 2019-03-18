package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.UserPro;
import zxl.web.domain.UserProKey;
import zxl.web.mapper.UserProMapper;
import zxl.web.service.IUserProService;

import java.util.List;

@Service
public class UserProServiceImpl implements IUserProService {
   @Autowired
    UserProMapper mapper;

    @Override
    public List<UserPro> selectUPs(int proid) {
        return mapper.selectUPs(proid);
    }

    @Override
    public void deleteproid(UserProKey userProKey) {
        mapper.deleteByPrimaryKey(userProKey);
    }

    @Override
    public void insert(UserPro userPro) {
        mapper.insert(userPro);
    }
}
