package v2.model;

import java.util.List;

public class Book implements Passage {
    private String title;
    private List<Chapter> chapters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        for (Chapter c: chapters) {
            c.setBookTitle(title);
        }

        this.chapters = chapters;
    }

    @Override
    public int getVerses() {
        return chapters.stream()
                .mapToInt(Chapter::getVerses)
                .sum();
    }

    @Override
    public String toString() {
        return title + " (" + getVerses() + " verses)";
    }
}
