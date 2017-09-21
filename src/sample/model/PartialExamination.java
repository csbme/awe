package sample.model;

public class PartialExamination {

    private SubjectCollection subjectCollection;
    private String label;

    public SubjectCollection getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(SubjectCollection subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
