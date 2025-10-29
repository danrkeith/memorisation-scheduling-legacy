package v1;

import java.util.ArrayList;
import java.util.List;

public class ChapterRange implements Passage {
    private final String bookTitle;
    private final List<Chapter> chapters = new ArrayList<>();
    private int verses = 0;

    public ChapterRange(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
        verses += chapter.getVerses();
    }

    public int getVerses() {
        return verses;
    }

    @Override
    public String toString() {
        return bookTitle + " " + chapters.getFirst().getChapter() + "-" + chapters.getLast().getChapter() + " (" + getVerses() + " verses)";
    }
}
