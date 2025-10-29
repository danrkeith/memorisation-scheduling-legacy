package v2.memorisation_spec;

import v2.Passage;

public class Chapter implements Passage {
    private int chapter;
    private int verses;

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setVerses(int verses) {
        this.verses = verses;
    }

    @Override
    public int getVerses() {
        return verses;
    }
}
