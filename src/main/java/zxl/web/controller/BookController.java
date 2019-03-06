package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Book;
import zxl.web.service.IBookService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import zxl.web.domain.User;
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
        for(int i=0;i<books.size();i++)
        {
            System.out.println(books.get(i).getBabstract());
        }
        return "book/book_list";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req)
    {
        String bid = req.getParameter("bid");
        Book bookForEdit = bookService.selectCourse(Integer.parseInt(bid));
        model.addAttribute("bookForEdit", bookForEdit);
        List<User> teachers = userService.queryAllTeacher();
        model.addAttribute("teachers", teachers);
        return "book/edit";
    }

    @RequestMapping("/save")
    public String save(Model model, HttpServletRequest req, Book book)
    {
        String[] bid = req.getParameterValues("userbook");
        return "redirect:/book/index";
    }


}
