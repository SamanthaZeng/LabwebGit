package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Book;
import zxl.web.mapper.BookMapper;
import zxl.web.service.IBookService;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookMapper mapper;

    @Override
    public List<Book> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public Book selectCourse(int bid) {
        return mapper.selectByPrimaryKey(bid);
    }

    @Override
    public int save(Book book) {
        return mapper.insert(book);
    }

    @Override
    public int update(Book book) {
        return mapper.updateByPrimaryKey(book);
    }
}
