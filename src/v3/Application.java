package v3;

import v3.model.MemorisationSpec;
import v3.model.Plan;

public class Application {

    public static void main(String[] args) {
        MemorisationSpec memorisationSpec = InputReader.read();

        int maxVersesPerDay = PlanOptimiser.minMaxVersesPerDay(memorisationSpec.getBooks(), memorisationSpec.getDays());

        Plan plan = PlanBuilder.buildFromBooks(memorisationSpec.getBooks(), maxVersesPerDay);
        PlanBuilder.addPsalmsToPlan(plan, memorisationSpec.getPsalms());

        System.out.println(plan);
    }

}
