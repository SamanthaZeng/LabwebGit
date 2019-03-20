package zxl.web.service;

import zxl.web.domain.UserPaper;
import zxl.web.domain.UserPaperKey;

import java.util.List;

public interface IUserPaperService {

    //根据论文Id返回所有包含该Id的项
    public List<UserPaper> selectUPps(int pid);

    //根据论文ID删除所有包含该id的项
    public void deletepid(UserPaperKey userPaperKey);

    //插入新项
    public void insert(UserPaper userPaper);
}
