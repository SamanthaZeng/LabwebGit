package zxl.web.domain;

public class News {
    private Integer newsid;

    private String newstitle;

    private String newsdescription;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    public String getNewsdescription() {
        return newsdescription;
    }

    public void setNewsdescription(String newsdescription) {
        this.newsdescription = newsdescription == null ? null : newsdescription.trim();
    }
}