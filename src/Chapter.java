public class Chapter {
    private int chapter;
    private int verses;

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getVerses() {
        return verses;
    }

    public void setVerses(int verses) {
        this.verses = verses;
    }

    @Override
    public String toString() {
        return "Chapter " + chapter + " (" + verses + " verses)";
    }
}
