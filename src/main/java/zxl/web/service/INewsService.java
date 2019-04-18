package zxl.web.service;

import zxl.web.domain.News;

import java.util.List;

public interface INewsService {
    List<News> queryAll();

    void deleteByNewsId(int newsid);

    News selectByNewsId(int newsid);

    void insert(News news);

    void update(News news);
    //返回newsid
    public int selectNewsid(News news);
}
