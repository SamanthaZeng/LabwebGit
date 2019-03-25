package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.UserPaper;
import zxl.web.domain.UserPaperKey;
import zxl.web.mapper.UserPaperMapper;
import zxl.web.service.IUserPaperService;

import java.util.List;

@Service
public class UserPaperServiceImpl implements IUserPaperService {
    @Autowired
    UserPaperMapper mapper;

    @Override
    public List<UserPaper> selectUPps(int pid) {
        return mapper.selectUPps(pid);
    }

    @Override
    public List<UserPaper> selectUPpsById(int id) {
        return mapper.selectUPpsById(id);
    }

    @Override
    public void deletepid(UserPaperKey userPaperKey) {
        mapper.deleteByPrimaryKey(userPaperKey);
    }

    @Override
    public void insert(UserPaper userPaper) {
        mapper.insert(userPaper);
    }
}
