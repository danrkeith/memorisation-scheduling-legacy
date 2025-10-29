package v2.memorisation_spec;

import java.util.List;

public class MemorisationSpec {
    private int days;
    private List<Book> books;
    private List<Psalm> psalms;

    public void setDays(int days) {
        this.days = days;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPsalms(List<Psalm> psalms) {
        this.psalms = psalms;
    }
}
