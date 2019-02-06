package zxl.web.domain;

public class Project {
    private Integer proid;

    private String number;

    private Integer prorank;

    private Integer protype;

    private String funding;

    private String proname;

    private String proabstract;

    private String prosource;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getProrank() {
        return prorank;
    }

    public void setProrank(Integer prorank) {
        this.prorank = prorank;
    }

    public Integer getProtype() {
        return protype;
    }

    public void setProtype(Integer protype) {
        this.protype = protype;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding == null ? null : funding.trim();
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getProabstract() {
        return proabstract;
    }

    public void setProabstract(String proabstract) {
        this.proabstract = proabstract == null ? null : proabstract.trim();
    }

    public String getProsource() {
        return prosource;
    }

    public void setProsource(String prosource) {
        this.prosource = prosource == null ? null : prosource.trim();
    }
}