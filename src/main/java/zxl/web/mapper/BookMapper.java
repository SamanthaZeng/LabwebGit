package zxl.web.mapper;

import zxl.web.domain.Book;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryAll();

    Book queryOne(Book book);

    void delete(Book book);
}