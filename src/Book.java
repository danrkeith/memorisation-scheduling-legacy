import java.util.List;

public class Book {
    private String book;
    private List<Chapter> chapters;

    public void setBook(String book) {
        this.book = book;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getVerses() {
        int verses = 0;
        for (Chapter chapter : chapters) {
            verses += chapter.getVerses();
        }
        return verses;
    }

    @Override
    public String toString() {
        return book + " (" + getVerses() + " verses)";
    }
}
