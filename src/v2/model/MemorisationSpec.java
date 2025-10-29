package v2.model;

import java.util.List;

public class MemorisationSpec {
    private int days;
    private List<Book> books;
    private List<Psalm> psalms;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Psalm> getPsalms() {
        return psalms;
    }

    public void setPsalms(List<Psalm> psalms) {
        this.psalms = psalms;
    }
}
