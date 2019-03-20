package zxl.web.domain;

public class UserPaper extends UserPaperKey {
    private String papernumber;

    private int authornumber;

    public String getPapernumber() {
        return papernumber;
    }

    public void setPapernumber(String papernumber) {
        this.papernumber = papernumber;
    }

    public int getAuthornumber() {
        return authornumber;
    }

    public void setAuthornumber(int authornumber) {
        this.authornumber = authornumber;
    }
}