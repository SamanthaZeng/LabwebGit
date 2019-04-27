package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Book;
import zxl.web.domain.UserBook;
import zxl.web.domain.UserBookKey;
import zxl.web.service.IBookService;
import zxl.web.service.IUserBookService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import zxl.web.domain.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserBookService userBookService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Book> books = bookService.queryAll();
        model.addAttribute("books", books);
        return "book/book_list";
    }

    /*进入新增页面*/
    @RequestMapping("/add")
    public String add(Model model)
    {
        System.out.println("进入add功能");
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        for(int i=0;i<users.size();i++)
            System.out.println(users.get(i).toString());
        return "book/edit";
    }


    @RequestMapping("/save")
    public String save(Book book,HttpServletRequest req){
        String authors[]=req.getParameterValues("authors");
        if(authors != null)
        {
            for(int i=0;i<authors.length;i++)
               System.out.println("authorid= "+authors[i]);
        }
        System.out.println("进入save");
        /*增加/更新 book表*/
        if(book!=null&&book.getBid()!=null&&!"".equals(book.getBid()))
            bookService.update(book);
        else
            bookService.save(book);
        /*增加或更新 userbook 表*/
       //1.获取书籍id
        int bid = book.getBid();
        //2.添加或更新userbook表
        List<UserBook> userBooks=userBookService.selectUBs(bid);
        int id;
        UserBookKey userBookKey=new UserBookKey();
        userBookKey.setBid(bid);
        if(userBooks.size()!=0)//更新
        {
            for(int i=0;i<userBooks.size();i++){
                id=userBooks.get(i).getId();
                userBookKey.setId(id);
                //删除掉所有bid=#{bid}的记录
                userBookService.deletebid(userBookKey);
            }
            UserBook author=new UserBook();
            //设置书的id
            author.setBid(bid);
            if(authors != null)
                for(int i=0;i<authors.length;i++){
                    //设置作者id和书号
                    author.setId(Integer.valueOf(authors[i]));
                    author.setBooknumber(String.valueOf(i));
                    userBookService.insert(author);
                }
        }else{//添加
            System.out.println("I am else");
            UserBook author=new UserBook();
            //设置书的id
            author.setBid(bid);
            if(authors != null)
                for(int i=0;i<authors.length;i++){
                    //设置作者id和书号
                    author.setId(Integer.valueOf(authors[i]));
                    author.setBooknumber(String.valueOf(i));
                    userBookService.insert(author);
                }
        }
        return "redirect:/book/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req,Book book)
    {
        Book book1=bookService.queryOne(book);
        int bid = Integer.parseInt(req.getParameter("bid"));
        List<User> users=userService.queryAll();
        List<UserBook> userBooks = userBookService.selectUBs(bid);
        ArrayList bookUsers = new ArrayList();
        for(int i=0;i<userBooks.size();i++)
        {
            bookUsers.add(userBooks.get(i).getId());
        }
        model.addAttribute("bookUsers", bookUsers);
        model.addAttribute("users",users);
        model.addAttribute("book", book1);
        return "book/edit";
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
