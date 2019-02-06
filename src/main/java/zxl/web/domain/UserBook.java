package zxl.web.domain;

public class UserBook extends UserBookKey {
    private String booknumber;

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber == null ? null : booknumber.trim();
    }
}