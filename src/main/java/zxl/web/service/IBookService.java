package zxl.web.service;

import zxl.web.domain.Book;

import java.util.List;

public interface IBookService {
    public List<Book> queryAll();
    public Book selectCourse(int bid);
    public int save(Book book);
    public int update(Book book);
}
