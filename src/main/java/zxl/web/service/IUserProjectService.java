package zxl.web.service;

import zxl.web.domain.UserPro;
import zxl.web.domain.UserProKey;

import java.util.List;

public interface IUserProjectService {
    /*获取所有该pid的USERPAPER项*/
    public List<UserPro> selectUPs(int proid);

    /*更新UP的项*/
    public void updateUPs(int proid,int id);

    /*删除有该pid的所有值*/
    public void deletebid(UserProKey userProKey);

    //添加新项
    public void insert(UserPro userPro);
}
