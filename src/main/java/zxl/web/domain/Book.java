package zxl.web.domain;

import java.sql.Date;

public class Book {
    private Integer bid;

    private String bookname;

    private String classification;

    private String babstract;

    private String press;

    private Date time;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }//trim去掉首尾空格

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getBabstract() {
        return babstract;
    }

    public void setBabstract(String babstract) {
        this.babstract = babstract == null ? null : babstract.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}