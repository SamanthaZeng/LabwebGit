package zxl.web.domain;

public class Classes {
    private Long id;
    private String class_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
