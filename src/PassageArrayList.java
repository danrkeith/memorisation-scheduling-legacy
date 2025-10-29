import java.util.ArrayList;

public class PassageArrayList<E extends Passage> extends ArrayList<E> implements PassageList<E> {
    @Override
    public int getVerses() {
        int verses = 0;
        for (Passage p : this) {
            verses += p.getVerses();
        }
        return verses;
    }
}
