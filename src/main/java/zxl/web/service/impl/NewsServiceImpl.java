package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.News;
import zxl.web.mapper.NewsMapper;
import zxl.web.service.INewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsMapper mapper;
    @Override
    public List<News> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public void deleteByNewsId(int newsid) {
        mapper.deleteByPrimaryKey(newsid);
    }

    @Override
    public News selectByNewsId(int newsid) {
        return mapper.selectByPrimaryKey(newsid);
    }

    @Override
    public void insert(News news) {
        mapper.insertSelective(news);
    }

    @Override
    public void update(News news) {
        mapper.updateByPrimaryKey(news);
    }

    @Override
    public int selectNewsid(News news) {
        return mapper.selectNewsid(news);
    }
}
