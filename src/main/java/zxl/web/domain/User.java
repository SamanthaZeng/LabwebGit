package zxl.web.domain;

import java.sql.Date;


public class User {
    private Integer id;

    private Integer tid;

    private Integer cid;

    private Integer sid;

    private String username;

    private String pwd;

    private Integer sex;

    private String imgurl;

    private Boolean isadmin=false;

    private Integer usertype;

    private String realname;

    private String engname;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getRealname() { return realname; }

    public void setRealname(String realname) { this.realname = realname; }

    public String getEngname() { return engname; }

    public void setEngname(String engname) { this.engname = engname; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tid=" + tid +
                ", cid=" + cid +
                ", sid=" + sid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", imgurl='" + imgurl + '\'' +
                ", isadmin=" + isadmin +
                ", usertype=" + usertype +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}