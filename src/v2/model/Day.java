package v2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day {
    private Passage mainPassage;
    private final List<Psalm> psalms = new ArrayList<>();

    public Day(Passage mainPassage) {
        this.mainPassage = mainPassage;
    }

    @Override
    public String toString() {
        String str = mainPassage.toString();

        if (!psalms.isEmpty()) {
            str += ", " + psalms.stream()
                    .map(Psalm::toString)
                    .collect(Collectors.joining(", "));
        }

        return str;
    }
}
