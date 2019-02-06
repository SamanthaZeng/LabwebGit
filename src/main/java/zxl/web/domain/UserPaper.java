package zxl.web.domain;

public class UserPaper extends UserPaperKey {
    private String papernumber;

    private Boolean iscorrespondingauthor;

    public String getPapernumber() {
        return papernumber;
    }

    public void setPapernumber(String papernumber) {
        this.papernumber = papernumber == null ? null : papernumber.trim();
    }

    public Boolean getIscorrespondingauthor() {
        return iscorrespondingauthor;
    }

    public void setIscorrespondingauthor(Boolean iscorrespondingauthor) {
        this.iscorrespondingauthor = iscorrespondingauthor;
    }
}