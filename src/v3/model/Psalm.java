package v3.model;

public class Psalm extends Chapter {
    @Override
    public String toString() {
        return "Psalm " + getChapter() + " (" + getVerses() + " verses)";
    }
}
