package v2;

import v2.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PlanBuilder {
    public static void addPsalmsToPlan(Plan plan, List<Psalm> psalms) {
        LinkedList<Psalm> descendingPsalms = new LinkedList<>(psalms);
        descendingPsalms.sort(Comparator.comparing(Psalm::getVerses).reversed());

        List<Day> ascendingDays = new ArrayList<>(plan.getDays());
        ascendingDays.sort(Comparator.comparing(Day::getVerses));

        while (descendingPsalms.size() >= ascendingDays.size()) {
            for (Day day : ascendingDays) {
                day.addPsalm(descendingPsalms.pop());
            }
        }

        int i = 0;
        while (!descendingPsalms.isEmpty()) {
            ascendingDays.get(i).addPsalm(descendingPsalms.pop());
            i++;
        }
    }

    public static Plan buildFromBooks(List<Book> books, int maxVersesPerDay) {
        Plan plan = new Plan();
        for (Book book : books) {
            plan.concatenate(buildFromBook(book, maxVersesPerDay));
        }
        return plan;
    }

    private static Plan buildFromBook(Book book, int maxVersesPerDay) {
        // Does entire book fit in one day?
        if (book.getVerses() <= maxVersesPerDay) {
            return new Plan(new Day(book));
        }

        Plan plan = new Plan();
        List<Chapter> chapters = book.getChapters();
        int chapterIndex = 0;

        while (chapterIndex < chapters.size()) {
            // Is this the last chapter OR will combining it with the following chapter exceed maxVersesPerDay?
            if (
                chapterIndex == chapters.size() - 1
                || chapters.get(chapterIndex).getVerses() + chapters.get(chapterIndex + 1).getVerses() > maxVersesPerDay
            ) {
                // Add single chapter
                plan.addDay(new Day(chapters.get(chapterIndex)));
                chapterIndex++;
            } else {
                // Add multiple chapters
                ChapterGroup group = new ChapterGroup(book.getTitle());

                // Stop when at the last chapter or when the next chapter will make the group exceed maxVersesPerDay
                do {
                    group.add(chapters.get(chapterIndex));
                    chapterIndex++;
                } while (
                    chapterIndex < chapters.size()
                    && group.getVerses() + chapters.get(chapterIndex).getVerses() <= maxVersesPerDay
                );

                plan.addDay(new Day(group));
            }
        }

        return plan;
    }
}
