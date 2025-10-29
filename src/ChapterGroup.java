public class ChapterGroup implements Passage {
    private final String bookTitle;
    private final PassageList<Chapter> chapters = new PassageArrayList<>();

    public ChapterGroup(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public int getVerses() {
        return chapters.getVerses();
    }

    @Override
    public String toString() {
        return bookTitle + " " + chapters.getFirst().getChapter() + "-" + chapters.getLast().getChapter() + " (" + getVerses() + " verses)";
    }
}
