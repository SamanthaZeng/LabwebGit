package zxl.web.service;

import zxl.web.domain.Book;

import java.util.List;

public interface IBookService {
    public List<Book> queryAll();
    public int save(Book book);
    public int update(Book book);
    public Book queryOne(Book book);
    public void delete(Book book);
    public int selectBid(Book book);
}
