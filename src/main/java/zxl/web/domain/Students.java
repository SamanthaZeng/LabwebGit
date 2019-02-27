package zxl.web.domain;

import java.util.Date;

public class Students {
    private Integer sid;

    private Integer id;

    private Integer srank;

    private User user;

    private String smail;

    private String wheretogo;

    private Date entertime;

    private String stueduexp;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrank() {
        return srank;
    }

    public void setSrank(Integer srank) {
        this.srank = srank;
    }

    public String getSmail() {
        return smail;
    }

    public void setSmail(String smail) {
        this.smail = smail == null ? null : smail.trim();
    }

    public String getWheretogo() {
        return wheretogo;
    }

    public void setWheretogo(String wheretogo) {
        this.wheretogo = wheretogo == null ? null : wheretogo.trim();
    }

    public Date getEntertime() {
        return entertime;
    }

    public void setEntertime(Date entertime) {
        this.entertime = entertime;
    }

    public String getStueduexp() {
        return stueduexp;
    }

    public void setStueduexp(String stueduexp) {
        this.stueduexp = stueduexp == null ? null : stueduexp.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", id=" + id +
                ", srank=" + srank +
                ", smail='" + smail + '\'' +
                ", wheretogo='" + wheretogo + '\'' +
                ", entertime=" + entertime +
                ", stueduexp='" + stueduexp + '\'' +
                '}';
    }
}