package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Book;
import zxl.web.service.IBookService;
import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

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


}
