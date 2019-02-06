package zxl.web.domain;

public class Cooperator {
    private Integer cid;

    private Integer coid;

    private Integer id;

    private String title;

    private String cduty;

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
}