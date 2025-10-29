package v2.model;

import java.util.ArrayList;
import java.util.List;

public class ChapterGroup implements Passage {
    private final String bookTitle;
    private final List<Chapter> chapters = new ArrayList<>();

    public ChapterGroup(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void add(Chapter chapter) {
        chapters.add(chapter);
    }

    @Override
    public int getVerses() {
        return chapters.stream()
                .mapToInt(Chapter::getVerses)
                .sum();
    }

    @Override
    public String toString() {
        return bookTitle + " " + chapters.getFirst().getChapter() + "-" + chapters.getLast().getChapter() + " (" + getVerses() + " verses)";
    }
}
