import java.util.List;

public class Application {
    public static void main(String[] args) {
        MemorisationSpec memorisationSpec = InputReader.read();

        List<Passage> plan = memorisationSpec.buildPlan();

        for (Passage passage : plan) {
            System.out.println(passage);
        }
    }
}
