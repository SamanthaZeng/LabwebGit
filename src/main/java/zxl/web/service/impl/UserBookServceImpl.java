package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.UserBook;
import zxl.web.domain.UserBookKey;
import zxl.web.mapper.UserBookMapper;
import zxl.web.service.IUserBookService;

import java.util.List;

@Service
public class UserBookServceImpl  implements IUserBookService {
    @Autowired
    UserBookMapper mapper;
    @Override
    public List<UserBook> selectUBs(int bid) {
        return mapper.selectUBs(bid);
    }

    @Override
    public void updateUBs(int bid, int id) {
       // mapper.
    }

    @Override
    public void deletebid(UserBookKey userBookKey) {
        mapper.deleteByPrimaryKey(userBookKey);
    }

    @Override
    public void insert(UserBook userBook) {
        mapper.insert(userBook);
    }
}
