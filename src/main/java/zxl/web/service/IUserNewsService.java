package zxl.web.service;

import zxl.web.domain.UserNewsKey;

import java.util.List;

public interface IUserNewsService {
    void deleteByPrimaryKey(UserNewsKey key);

    void insert(UserNewsKey record);

    List<UserNewsKey> selectByNewsId(int newsid);

    void deleteByNewsId(int newsid);
}
