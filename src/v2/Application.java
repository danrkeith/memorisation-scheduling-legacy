package v2;

import v2.model.MemorisationSpec;
import v2.model.Plan;

public class Application {
    public static void main(String[] args) {
        MemorisationSpec memorisationSpec = InputReader.read();

        int maxVersesPerDay = PlanOptimiser.minMaxVersesPerDay(memorisationSpec.getBooks(), memorisationSpec.getDays());

        Plan plan = PlanBuilder.buildFromBooks(memorisationSpec.getBooks(), maxVersesPerDay);

        System.out.println(plan);
    }
}
