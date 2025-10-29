import java.util.ArrayList;
import java.util.List;

public class Book implements Passage {
    private String title;
    private List<Chapter> chapters;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChapters(List<Chapter> chapters) {
        for (Chapter c : chapters) {
            c.setBookTitle(title);
        }
        
        this.chapters = chapters;
    }

    public int getVerses() {
        int verses = 0;

        for (Chapter chapter : chapters) {
            verses += chapter.getVerses();
        }

        return verses;
    }

    public List<Passage> buildPlan(int minMaxVersesPerDay) {
        List<Passage> plan = new ArrayList<>();

        int chapterIndex = 0;
        while (chapterIndex < chapters.size()) {
            // Is this the last chapter, or would two chapters be too long?
            if (
                chapterIndex == chapters.size() - 1
                || chapters.get(chapterIndex).getVerses() + chapters.get(chapterIndex + 1).getVerses() > minMaxVersesPerDay
            ) {
                // Add single chapter
                plan.add(chapters.get(chapterIndex));
                chapterIndex++;
            } else {
                // Add multiple chapters
                ChapterGroup chapterGroup = new ChapterGroup(title);

                do {
                    chapterGroup.addChapter(chapters.get(chapterIndex));
                    chapterIndex++;
                } while (
                    chapterIndex < chapters.size()
                    && chapterGroup.getVerses() + chapters.get(chapterIndex).getVerses() <= minMaxVersesPerDay
                );

                plan.add(chapterGroup);
            }
        }

        return plan;
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
        return title + " (" + getVerses() + " verses)";
    }
}
