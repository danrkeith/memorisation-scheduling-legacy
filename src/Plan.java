import java.util.List;

public class Plan {
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

    private int getVerses() {
        int verses = 0;
        for (Book book : books) {
            verses += book.getVerses();
        }
        for (Psalm psalm : psalms) {
            verses += psalm.getVerses();
        }
        return verses;
    }

    @Override
    public String toString() {
        return "Plan (" + getVerses() + " verses over " + days + " days)";
    }
}
