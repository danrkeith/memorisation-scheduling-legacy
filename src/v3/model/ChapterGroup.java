package v3.model;

import java.util.ArrayList;
import java.util.List;

public class ChapterGroup implements Passage {
    private String bookTitle;
    private final List<Chapter> chapters = new ArrayList<>();

    public ChapterGroup(Chapter chapter) {
        this.chapters.add(chapter);
    }

    public ChapterGroup(List<Chapter> chapters) {
        this.chapters.addAll(chapters);
    }

    // TODO - generate label
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void add(Chapter chapter) {
        chapters.add(chapter);
    }

    public void add(ChapterGroup chapterGroup) {
        chapters.addAll(chapterGroup.chapters);
    }

    @Override
    public int getVerses() {
        return chapters.stream()
                .mapToInt(Passage::getVerses)
                .sum();
    }

    @Override
    public String toString() {
        if (chapters.isEmpty()) {
            return null;
        }

        return bookTitle + " " + chapters.getFirst().getChapter() + (
                chapters.size() == 1 ? "" : "-" + chapters.getLast().getChapter()
            ) + " (" + getVerses() + " verses)";
    }
}
