package zxl.web.service;

import zxl.web.domain.UserPaper;
import zxl.web.domain.UserPaperKey;

import java.util.List;

public interface IUserPaperService {
    /*获取所有该pid的USERPAPER项*/
    public List<UserPaper> selectUPs(int pid);

    /*更新UP的项*/
    public void updateUBs(int bid,int id);

    /*删除有该pid的所有值*/
    public void deletebid(UserPaperKey userPaperKey);

    //添加新项
    public void insert(UserPaper userPaper);
}
