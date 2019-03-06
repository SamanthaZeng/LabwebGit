package zxl.web.domain;

public class UserCourse extends UserCourseKey {
    private Integer teachertype;

    public Integer getTeachertype() {
        return teachertype;
    }

    public void setTeachertype(Integer teachertype) {
        this.teachertype = teachertype;
    }

    public UserCourse(int id, int clsid)
    {
        super(id, clsid);
    }

    public UserCourse()
    {
        super();
    }
}