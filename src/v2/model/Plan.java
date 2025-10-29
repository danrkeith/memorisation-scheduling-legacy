package v2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Plan {
    private final List<Day> days = new ArrayList<>();

    public Plan() { }

    public Plan(Day day) {
        addDay(day);
    }

    public List<Day> getDays() {
        return days;
    }

    public void addDay(Day d) {
        days.add(d);
    }

    public void concatenate(Plan plan) {
        days.addAll(plan.days);
    }

    private int getVerses() {
        return days.stream()
                .mapToInt(Day::getVerses)
                .sum();
    }

    @Override
    public String toString() {
        return "Plan (" + getVerses() + " verses)\n" +
                IntStream.range(0, days.size())
                .mapToObj(i -> "\tDay " + (i + 1) + " (" + days.get(i).getVerses() + " verses): \t" + days.get(i))
                .collect(Collectors.joining("\n"));
    }
}
