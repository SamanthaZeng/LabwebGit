package zxl.web.domain;

public class Teacher {
    private Integer tid;

    private Integer id;

    private Integer trank;

    private String service;

    private String teduexp;

    private String tmail;

    private String workexp;

    private String tduty;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrank() {
        return trank;
    }

    public void setTrank(Integer trank) {
        this.trank = trank;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getTeduexp() {
        return teduexp;
    }

    public void setTeduexp(String teduexp) {
        this.teduexp = teduexp == null ? null : teduexp.trim();
    }

    public String getTmail() {
        return tmail;
    }

    public void setTmail(String tmail) {
        this.tmail = tmail == null ? null : tmail.trim();
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp == null ? null : workexp.trim();
    }

    public String getTduty() {
        return tduty;
    }

    public void setTduty(String tduty) {
        this.tduty = tduty == null ? null : tduty.trim();
    }
}