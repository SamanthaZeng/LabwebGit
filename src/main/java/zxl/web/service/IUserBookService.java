package zxl.web.service;

import zxl.web.domain.UserBook;
import zxl.web.domain.UserBookKey;

import java.util.List;

public interface IUserBookService {
    /*获取所有该bid的USERBOOK项*/
    public List<UserBook> selectUBs(int bid);

    /*更新ub的项*/
    public void updateUBs(int bid,int id);

    /*删除有该Bid的所有值*/
    public void deletebid(UserBookKey userBookKey);

    //添加新项
    public void insert(UserBook userBook);

    public List<UserBook>selectBidByid(int id);
}
