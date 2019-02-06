package zxl.web.domain;

public class Student {
    //学生ID
    private Long id;
    //学生名字
    private String name;
    //学生密码
    private String pwd;
    //学生学号
    private String stunum;
    //学生头像
    private String imgUrl;
    //班级
    private Classes classes;//多个学生对一个班级
    //性别
    private Boolean sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", stunum='" + stunum + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", classes=" + classes +
                ", sex=" + sex +
                '}';
    }
}
