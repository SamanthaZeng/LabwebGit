package zxl.web.domain;

public class Researcharea {
    private Integer rid;

    private String rname;

    private String intro;

    private String imgurl1;

    private String imgurl2;

    private String imgurl3;

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

    public String getImgurl1() {
        return imgurl1;
    }

    public void setImgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getImgurl3() {
        return imgurl3;
    }

    public void setImgurl3(String imgurl3) {
        this.imgurl3 = imgurl3;
    }

    @Override
    public String toString() {
        return "Researcharea{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", intro='" + intro + '\'' +
                ", imgurl1='" + imgurl1 + '\'' +
                ", imgurl2='" + imgurl2 + '\'' +
                ", imgurl3='" + imgurl3 + '\'' +
                '}';
    }
}