package v3.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Passage {
    private String label;
    private final List<Passage> passages = new ArrayList<>();

    public Section(Passage passage) {
        this.passages.add(passage);
    }

    public Section(List<? extends Passage> passages) {
        this.passages.addAll(passages);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void add(Passage passage) {
        passages.add(passage);
    }

    public void add(Section section) {
        passages.addAll(section.passages);
    }

    @Override
    public int getVerses() {
        return passages.stream()
                .mapToInt(Passage::getVerses)
                .sum();
    }

    @Override
    public String toString() {
        return label + " (" + getVerses() + " verses)";
    }
}
