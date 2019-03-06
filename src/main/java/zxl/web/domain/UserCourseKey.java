package zxl.web.domain;

public class UserCourseKey {
    private Integer id;

    private Integer clsid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClsid() {
        return clsid;
    }

    public void setClsid(Integer clsid) {
        this.clsid = clsid;
    }

    public UserCourseKey(int id, int clsid)
    {
        this.setId(id);
        this.setClsid(clsid);
    }
    public UserCourseKey()
    {}
}