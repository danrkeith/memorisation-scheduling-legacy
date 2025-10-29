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

    public void addDay(Day d) {
        days.add(d);
    }

    public void concatenate(Plan plan) {
        days.addAll(plan.days);
    }

    @Override
    public String toString() {
        return IntStream.range(0, days.size())
                .mapToObj(i -> "Day " + (i + 1) + ": " + days.get(i))
                .collect(Collectors.joining("\n"));
    }
}
