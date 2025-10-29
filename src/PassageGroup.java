import java.util.ArrayList;
import java.util.List;

public class PassageGroup<T extends Passage> implements Passage {
    protected List<T> passages = new ArrayList<>();
    private int verses = 0;

    public void add(T passage) {
        passages.add(passage);
        verses += passage.getVerses();
    }

    protected void setPassages(List<T> passages) {
        this.passages = passages;

        verses = 0;
        for (Passage passage : passages) {
            verses += passage.getVerses();
        }
    }

    public int getVerses() {
        return verses;
    }
}
