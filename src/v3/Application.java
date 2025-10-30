package v3;

import v3.model.MemorisationSpec;
import v3.model.ChapterGroup;

public class Application {

    public static void main(String[] args) {
        MemorisationSpec memorisationSpec = InputReader.read();

        for (ChapterGroup chapterGroup : memorisationSpec.getBooks().getFirst().getChapterGroups()) {
            System.out.println(chapterGroup);
        }
    }

}
