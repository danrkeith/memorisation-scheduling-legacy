package v3;

import v3.model.MemorisationSpec;
import v3.model.Section;

public class Application {

    public static void main(String[] args) {
        MemorisationSpec memorisationSpec = InputReader.read();

        for (Section section : memorisationSpec.getBooks().getFirst().getSections()) {
            System.out.println(section);
        }
    }

}
