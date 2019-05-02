package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.News;
import zxl.web.domain.User;
import zxl.web.domain.UserNewsKey;
import zxl.web.service.INewsService;
import zxl.web.service.IUserNewsService;
import zxl.web.service.IUserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @Autowired
    private IUserNewsService userNewsService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<News> newsList = newsService.queryAll();
        for(int i=0; i<newsList.size();i++)
        {
            String str = newsList.get(i).getNewsdescription();
            newsList.get(i).setNewsdescription(cutStr(str, 50));
            str = newsList.get(i).getNewstitle();
            newsList.get(i).setNewstitle(cutStr(str, 30));
        }
        model.addAttribute(newsList);
        return "news/news_list";
    }

    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest req)
    {
        return "news/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int newsid = Integer.parseInt(req.getParameter("newsid"));
        newsService.deleteByNewsId(newsid);
        return "redirect:/news/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req)
    {
        int newsid = Integer.parseInt(req.getParameter("newsid"));
        News news = newsService.selectByNewsId(newsid);
        model.addAttribute("news" ,news);
        return "news/edit";
    }

    @RequestMapping("/save")
    public String save(Model model, News news, HttpServletRequest req) {
        int newsid;
        System.out.println(news.getNewsdescription());
        if(news.getNewsid() == null) {
            newsService.insert(news);
            newsid=newsService.selectNewsid(news);
        }
        else {/*更新才需要删除原来的usernews*/
            newsService.update(news);
            newsid=news.getNewsid();
            userNewsService.deleteByNewsId(newsid);
        }
        UserNewsKey userNewsKey = new UserNewsKey();
        userNewsKey.setNewsid(newsid);
        User user = (User)req.getSession().getAttribute("user");
        userNewsKey.setId(user.getId());
        userNewsService.insert(userNewsKey);
        return "redirect:/news/index";
    }

    public static String cutStr(String strs, int length) {
        int sum = 0;
        String finalStr = "";
        if (null == strs || strs.getBytes().length <= length) {
            finalStr = (strs==null?"":strs);
        } else {
            for (int i = 0; i < strs.length(); i++) {
                String str = strs.substring(i, i + 1);
                // 累加单个字符字节数
                sum += str.getBytes().length;
                if (sum > length) {
                    finalStr = strs.substring(0, i) + "...";
                    break;
                }
            }
        }
        return finalStr;
    }

    public static boolean ifInAssociations(List<UserNewsKey> associations, int forTest)
    {
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getId())
                return true;
        }
        return false;
    }
}
