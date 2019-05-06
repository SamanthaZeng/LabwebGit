package zxl.web.domain;

public class Cooperator {
    private Integer cid;

    private Integer coid;

    private Integer id;

    private String title;

    private String cduty;

    private String cmail;

    private String cpage;
    
    private String cresearcharea;

    private User user;

    private Company company;

    public String getCresearcharea() {
        return cresearcharea;
    }

    public void setCresearcharea(String cresearcharea) {
        this.cresearcharea = cresearcharea;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCduty() {
        return cduty;
    }

    public void setCduty(String cduty) {
        this.cduty = cduty == null ? null : cduty.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCmail() {
        return cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

    public String getCpage() {
        return cpage;
    }

    public void setCpage(String cpage) {
        this.cpage = cpage;
    }

    @Override
    public String toString() {
        return "Cooperator{" +
                "cid=" + cid +
                ", coid=" + coid +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", cduty='" + cduty + '\'' +
                ", cmail='" + cmail + '\'' +
                ", cpage='" + cpage + '\'' +
                ", cresearcharea='" + cresearcharea + '\'' +
                ", user=" + user +
                ", company=" + company +
                '}';
    }
}