public class ChapterRange extends PassageGroup<Chapter> {
    private final String bookTitle;

    public ChapterRange(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return bookTitle + " " + passages.getFirst().getChapter() + "-" + passages.getLast().getChapter() + " (" + getVerses() + " verses)";
    }
}
