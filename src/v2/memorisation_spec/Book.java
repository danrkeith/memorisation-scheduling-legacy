package v2.memorisation_spec;

import v2.Passage;

import java.util.List;

public class Book implements Passage {
    private String title;
    private List<Chapter> chapters;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public int getVerses() {
        return chapters.stream()
                .mapToInt(Chapter::getVerses)
                .sum();
    }
}
