package zxl.web.domain;

public class UserPro extends UserProKey {
    private String pronumber;

    private Boolean isleader;

    public String getPronumber() {
        return pronumber;
    }

    public void setPronumber(String pronumber) {
        this.pronumber = pronumber == null ? null : pronumber.trim();
    }

    public Boolean getIsleader() {
        return isleader;
    }

    public void setIsleader(Boolean isleader) {
        this.isleader = isleader;
    }
}