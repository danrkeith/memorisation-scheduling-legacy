package v2.model;

public class Psalm implements Passage {
    private int psalm;
    private int verses;

    public void setPsalm(int psalm) {
        this.psalm = psalm;
    }

    public void setVerses(int verses) {
        this.verses = verses;
    }

    @Override
    public int getVerses() {
        return verses;
    }

    @Override
    public String toString() {
        return "Psalm " + psalm + " (" + verses + " verses)";
    }
}
