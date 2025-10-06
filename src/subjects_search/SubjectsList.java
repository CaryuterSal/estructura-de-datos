package subjects_search;

import java.util.ArrayList;
import java.util.List;

public class SubjectsList {
    private final List<String> subjects = new ArrayList<>();

    public void add(String subject) {
        subjects.add(subject);
    }

    public boolean contains(String subject) {
        return subjects.contains(subject);
    }

    public void print(){
        System.out.printf("Materias: %s%n", subjects);
    }
}
