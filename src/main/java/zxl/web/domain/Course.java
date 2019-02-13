package zxl.web.domain;

public class Course {
    private Integer clsid;

    private String name;

    private String cabstract;

    private Integer teachingobject;

    private Integer courseType;

    private Integer classhour;

    public Integer getClsid() {
        return clsid;
    }

    public void setClsid(Integer clsid) {
        this.clsid = clsid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbstract() {
        return cabstract;
    }

    public void setAbstract(String cabstract) {
        this.cabstract = cabstract == null ? null : cabstract.trim();
    }

    public Integer getTeachingobject() {
        return teachingobject;
    }

    public void setTeachingobject(Integer teachingobject) {
        this.teachingobject = teachingobject;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getClasshour() {
        return classhour;
    }

    public void setClasshour(Integer classhour) {
        this.classhour = classhour;
    }
}