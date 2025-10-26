import java.util.List;

public class Book {
    private String book;
    private List<Chapter> chapters;

    public void setBook(String book) {
        this.book = book;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getVerses() {
        int verses = 0;
        for (Chapter chapter : chapters) {
            verses += chapter.getVerses();
        }
        return verses;
    }

    public int minMaxVersesPerDay(int days) {
        // Find a possible and impossible maxVersesPerDay
        int possibleMaxVersesPerDay = 1;

        while (daysToMemorise(possibleMaxVersesPerDay) > days) {
            possibleMaxVersesPerDay *= 2;
        }

        int impossibleMaxVersesPerDay = possibleMaxVersesPerDay / 2;

        // Converge possibleMaxVersesPerDay and impossibleMaxVersesPerDay to be one apart
        while (possibleMaxVersesPerDay > impossibleMaxVersesPerDay + 1) {
            int middleMaxVersesPerDay = (possibleMaxVersesPerDay + impossibleMaxVersesPerDay) / 2;

            if (daysToMemorise(middleMaxVersesPerDay) > days) {
                impossibleMaxVersesPerDay = middleMaxVersesPerDay;
            } else {
                possibleMaxVersesPerDay = middleMaxVersesPerDay;
            }
        }

        return possibleMaxVersesPerDay;
    }

    private int daysToMemorise(int maxVersesPerDay) {
        int day = 1;
        int versesInDay = 0;

        for (Chapter chapter : chapters) {
            if (chapter.getVerses() > maxVersesPerDay) {
                return Integer.MAX_VALUE;
            }

            // Can the chapter be memorised today?
            if (versesInDay + chapter.getVerses() <= maxVersesPerDay) {
                // Memorise it today
                versesInDay += chapter.getVerses();
            } else {
                // Memorise it tomorrow
                day++;
                versesInDay = chapter.getVerses();
            }
        }

        return day;
    }

    @Override
    public String toString() {
        return book + " (" + getVerses() + " verses)";
    }
}
