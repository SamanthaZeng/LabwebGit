package zxl.web.domain;

public class PaperProjectKey {
    private Integer pid;

    private Integer proid;

    public PaperProjectKey(int proid, int pid)
    {
        this.pid = pid;
        this.proid = proid;
    }
    public PaperProjectKey (Paper paper, Project project)
    {
        this.pid = paper.getPid();
        this.proid = project.getProid();
    }
    public PaperProjectKey(Paper paper, int proid) {
        this.setPid(paper.getPid());
        this.setProid(proid);
    }

    public PaperProjectKey(Project project, int pid) {
        this.setProid(project.getProid());
        this.setPid(pid);
    }

    public PaperProjectKey()
    {}

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }
}