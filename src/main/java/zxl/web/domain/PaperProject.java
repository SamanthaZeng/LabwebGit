package zxl.web.domain;

public class PaperProject extends PaperProjectKey {
    private String serialnumber;

    public PaperProject(Paper paper, Project project) {
        super(paper, project);
    }

    public PaperProject(Project project, int pid) {
        super(project,pid);
    }

    public PaperProject(int proid, int pid) {
        super(proid, pid);
    }

    public PaperProject()
    {}
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }
}