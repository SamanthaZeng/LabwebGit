package zxl.web.domain;

import java.sql.Date;

public class Paper {
    private Integer pid;

    private String ptitile;

    private Date publictime;

    private String papersource;

    private String keyword;

    private String pabstract;

    private String paperurl;

    private String paperrank;

    private int papertype;

    private int paperindex;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPtitile() {
        return ptitile;
    }

    public void setPtitile(String ptitile) {
        this.ptitile = ptitile;
    }

    public Date getPublictime() {
        return publictime;
    }

    public void setPublictime(Date publictime) {
        this.publictime = publictime;
    }

    public String getPapersource() {
        return papersource;
    }

    public void setPapersource(String papersource) {
        this.papersource = papersource;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPabstract() {
        return pabstract;
    }

    public void setPabstract(String pabstract) {
        this.pabstract = pabstract;
    }

    public String getPaperurl() {
        return paperurl;
    }

    public void setPaperurl(String paperurl) {
        this.paperurl = paperurl;
    }

    public String getPaperrank() {
        return paperrank;
    }

    public void setPaperrank(String paperrank) {
        this.paperrank = paperrank;
    }

    public int getPaperindex() {
        return paperindex;
    }

    public void setPaperindex(int paperindex) {
        this.paperindex = paperindex;
    }

    public int getPapertype() {
        return papertype;
    }

    public void setPapertype(int papertype) {
        this.papertype = papertype;
    }
}