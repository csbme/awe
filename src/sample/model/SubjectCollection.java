package sample.model;

import java.util.ArrayList;

public class SubjectCollection {
    private ArrayList<Subject> subjects;

    public SubjectCollection() {
        subjects = new ArrayList<Subject>();
    }

    public ArrayList getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList subjects) {
        subjects = subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
}
