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
    public int save(Book book) {
        return mapper.insert(book);
    }

    @Override
    public int update(Book book) {
        return mapper.updateByPrimaryKey(book);
    }

    @Override
    public Book queryOne(Book book) {
        return mapper.queryOne(book);
    }

    @Override
    public void delete(Book book) {
        mapper.delete(book);
    }
}
