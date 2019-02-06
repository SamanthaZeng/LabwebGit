package zxl.web.domain;

public class Company {
    private Integer coid;

    private String coname;

    private Integer cotype;

    private String logourl;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname == null ? null : coname.trim();
    }

    public Integer getCotype() {
        return cotype;
    }

    public void setCotype(Integer cotype) {
        this.cotype = cotype;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl == null ? null : logourl.trim();
    }
}