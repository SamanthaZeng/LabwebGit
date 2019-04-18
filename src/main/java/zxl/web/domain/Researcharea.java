package zxl.web.domain;

public class Researcharea {
    private Integer rid;

    private String rname;

    private String intro;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Override
    public String toString() {
        return "Researcharea{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}