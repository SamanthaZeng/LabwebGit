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
    public List<UserPaper> selectUPs(int pid) {
        List<UserPaper> userPapers = mapper.selectByPid(pid);
        return userPapers;
    }

    @Override
    public void updateUBs(int bid, int id) {

    }

    @Override
    public void deletebid(UserPaperKey userPaperKey) {
        mapper.deleteByPrimaryKey(userPaperKey);
    }

    @Override
    public void insert(UserPaper userPaper) {
        mapper.insertSelective(userPaper);
    }
}
