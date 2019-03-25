package zxl.web.service;

import zxl.web.domain.UserPro;
import zxl.web.domain.UserProKey;

import java.util.List;

public interface IUserProService {
    //返回所有userpro项
    public List<UserPro> selectUPs(int proid);

    /*获取所有该id的USERPAPER项*/
    public List<UserPro> selectUPsById(int id);

    //删除所有proid=#{proid}
    public void deleteproid(UserProKey userProKey);

    //添加userpro项
    public void insert(UserPro userPro);
}
