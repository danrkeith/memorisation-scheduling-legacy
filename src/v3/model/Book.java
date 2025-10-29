package v3.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Chapter> chapters;
    private List<ChapterGroup> chapterGroups;

    private List<Section> sections;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void setChapterGroups(List<ChapterGroup> chapterGroups) {
        this.chapterGroups = chapterGroups;
    }

    public List<Section> getSections() {
        if (sections == null) {
            buildSections();
        }

        return sections;
    }

    private void buildSections() {
        sections = new ArrayList<>();

        int i = 0;
        while (i < chapters.size()) {
            Chapter chapter = chapters.get(i);
            ChapterGroup group = findGroupStartingAt(i + 1);

            // Is the chapter the first in a group?
            if (group == null) {
                // No; add chapter alone
                Section section = new Section(chapter);
                section.setLabel(title + " " + chapter.getChapter());
                sections.add(section);
                i++;
            } else {
                // Yes; add group
                Section section = new Section(
                        chapters.subList(group.getStart() - 1, group.getEnd())
                );
                section.setLabel(title + " " + group.getStart() + "-" + group.getEnd());
                sections.add(section);

                // Skip ahead past grouped chapters
                i = group.getEnd();
            }
        }
    }

    private ChapterGroup findGroupStartingAt(int chapter) {
        for (ChapterGroup group : chapterGroups) {
            if (group.getStart() == chapter) {
                return group;
            }
        }
        return null;
    }

    private int getVerses() {
        return chapters.stream().mapToInt(Passage::getVerses).sum();
    }

    @Override
    public String toString() {
        return title + " (" + getVerses() + " verses)";
    }
}
