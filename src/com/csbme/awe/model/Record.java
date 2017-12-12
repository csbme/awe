package com.csbme.awe.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {

    private final StringProperty subject;
    private final StringProperty grade;

    public Record() {
        this(null, null);
    }

    public Record(String subject, String grade) {
        this.subject = new SimpleStringProperty(subject);
        this.grade = new SimpleStringProperty(grade);
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public int getGradeValue() {
        return Integer.parseInt(grade.get());
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public StringProperty subjectProperty() {
        return subject;
    }
}