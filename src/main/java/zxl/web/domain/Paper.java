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
        this.ptitile = ptitile == null ? null : ptitile.trim();
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
        this.papersource = papersource == null ? null : papersource.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getPabstract() {
        return pabstract;
    }

    public void setPabstract(String pabstract) {
        this.pabstract = pabstract == null ? null : pabstract.trim();
    }

    public String getPaperurl() {
        return paperurl;
    }

    public void setPaperurl(String paperurl) {
        this.paperurl = paperurl == null ? null : paperurl.trim();
    }

    public String getPaperrank() {
        return paperrank;
    }

    public void setPaperrank(String paperrank) {
        this.paperrank = paperrank == null ? null : paperrank.trim();
    }
}