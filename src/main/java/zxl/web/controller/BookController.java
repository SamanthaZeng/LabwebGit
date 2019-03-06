package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Book;
import zxl.web.service.IBookService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import zxl.web.domain.User;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Book> books = bookService.queryAll();
        model.addAttribute("books", books);
        return "book/book_list";
    }

    /*进入新增页面*/
    @RequestMapping("/add")
    public String add()
    {
        return "book/book_input";
    }


    @RequestMapping("/save")
    public String save(Book book, @DateTimeFormat(pattern="yyyy-MM-dd") Date btime){
        System.out.println("进入save");
        book.setTime(btime);
        if(book!=null&&book.getBid()!=null&&!"".equals(book.getBid()))
            bookService.update(book);
        else
            bookService.save(book);
        System.out.println("save book success");
        return "redirect:/book/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req,Book book)
    {
        Book book1=bookService.queryOne(book);
       // String bid = req.getParameter("bid");
        model.addAttribute("book", book1);
        return "book/book_input";
    }

    /*批量删除*/
    @RequestMapping("/delete")
    public String delete(Book book)
    {
        System.out.println("进入删除功能");
        bookService.delete(book);
        return "redirect:/book/index";
    }


}
