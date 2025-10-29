import java.util.List;

public class MemorisationSpec {
    private int days;
    private List<Book> books;
    private List<Psalm> psalms;

    public void setDays(int days) {
        this.days = days;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPsalms(List<Psalm> psalms) {
        this.psalms = psalms;
    }

    public PassageList<Passage> buildPlan() {
        PassageList<Passage> plan = new PassageArrayList<>();
        int minMaxVersesPerDay = minMaxVersesPerDay();

        for (Book book : books) {
            if (book.getVerses() <= minMaxVersesPerDay) {
                plan.add(book);
            } else {
                plan.addAll(book.buildPlan(minMaxVersesPerDay));
            }
        }

        return plan;
    }

    private int minMaxVersesPerDay() {
        return minMaxVersesPerDay(books, days);
    }

    private static int minMaxVersesPerDay(List<Book> books, int days) {
        // Multiple books are not done in one day, so there must be at least as many books as days
        if (books.size() > days) {
            return Integer.MAX_VALUE;
        }

        if (books.size() == 1) {
            return books.getFirst().minMaxVersesPerDay(days);
        }

        if (books.size() == days) {
            int maxVersesPerDay = 0;

            for (Book book : books) {
                maxVersesPerDay = Integer.max(maxVersesPerDay, book.getVerses());
            }

            return maxVersesPerDay;
        }

        int minMaxVersesPerDay = Integer.MAX_VALUE;

        // Alter amount of days given to first book to find minMaxVersesPerDay
        for (int daysForFirstBook = 1; daysForFirstBook <= days - books.size() + 1; daysForFirstBook++) {
            int maxVersesPerDay = Integer.max(
                    books.getFirst().minMaxVersesPerDay(daysForFirstBook),
                    minMaxVersesPerDay(books.subList(1, books.size()), days - daysForFirstBook)
            );

            minMaxVersesPerDay = Integer.min(minMaxVersesPerDay, maxVersesPerDay);
        }

        return minMaxVersesPerDay;
    }

    private int getVerses() {
        int verses = 0;
        for (Book book : books) {
            verses += book.getVerses();
        }
        for (Psalm psalm : psalms) {
            verses += psalm.getVerses();
        }
        return verses;
    }

    @Override
    public String toString() {
        return "Memorisation Specifications (" + getVerses() + " verses over " + days + " days)";
    }
}
