import java.util.ArrayList;
import java.util.List;

public class ChapterRange implements Passage {
    private final String bookTitle;
    private final List<Chapter> chapters = new ArrayList<>();

    public ChapterRange(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
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
        return bookTitle + " " + chapters.getFirst().getChapter() + "-" + chapters.getLast().getChapter() + " (" + getVerses() + " verses)";
    }
}
