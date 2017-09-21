package sample;

import sample.constant.GradeValuation;
import sample.constant.Multiplier;
import sample.entity.grade.*;
import sample.interfaces.GradeInterface;
import sample.model.Grade;
import sample.model.PartialExamination;
import sample.model.Subject;
import sample.model.SubjectCollection;

import java.util.TreeMap;

public class Controller {

    private PartialExamination partA, partB;

    public PartialExamination getPartA() {
        return partA;
    }

    public void setPartA(PartialExamination partA) {
        this.partA = partA;
    }

    public PartialExamination getPartB() {
        return partB;
    }

    public void setPartB(PartialExamination partB) {
        this.partB = partB;
    }

    public Controller() {
        setPartA(setActionPartA());
        setPartB(setActionPartB());
    }

    public void initialize() {
        int points = 50;
        GradeInterface grade = evaluatePoints(points);
        grade.setPoints(points);
        System.out.println(grade.getValuation());
    }

    private boolean pointsAreInsufficient(int points) {
        return points >= GradeValuation.INSUFFICIENT && points < GradeValuation.DEFICIENT;
    }

    private boolean pointsAreDeficient(int points) {
        return points >= GradeValuation.DEFICIENT && points < GradeValuation.SUFFICIENT;
    }

    private boolean pointsAreAtLeastSufficient(int points) {
        return points >= GradeValuation.SUFFICIENT;
    }

    private GradeInterface evaluatePoints(int points) {
        TreeMap <Integer, GradeInterface> map = new TreeMap<>();
        map.put(GradeValuation.INSUFFICIENT, new Insufficient());
        map.put(GradeValuation.DEFICIENT, new Deficient());
        map.put(GradeValuation.SUFFICIENT, new Sufficient());
        map.put(GradeValuation.SATISFACTORY, new Satisfactory());
        map.put(GradeValuation.GOOD, new Good());
        map.put(GradeValuation.EXCELLENT, new Excellent());

        return map.floorEntry(points).getValue();
    }

    private PartialExamination setActionPartA() {
        Subject subjectProject = new Subject();
        subjectProject.setLabel("Projektarbeit");

        Subject subjectTalk = new Subject();
        subjectTalk.setLabel("Fachgespraech");

        SubjectCollection subjectCollection = new SubjectCollection();
        subjectCollection.addSubject(subjectProject);
        subjectCollection.addSubject(subjectTalk);

        PartialExamination partialExamination = new PartialExamination();
        partialExamination.setLabel("Teil A");
        partialExamination.setSubjectCollection(subjectCollection);

        return partialExamination;
    }

    private PartialExamination setActionPartB() {
        Subject subjectPartOne = new Subject();
        subjectPartOne.setLabel("Ganzheitliche Aufgabe I");
        subjectPartOne.setMultiplier(Multiplier.DOUBLE);

        Subject subjectTaskTwo = new Subject();
        subjectTaskTwo.setLabel("Ganzheitliche Aufgabe II");
        subjectTaskTwo.setMultiplier(Multiplier.DOUBLE);

        Subject subjectEconomics = new Subject();
        subjectEconomics.setLabel("Wirtschaft- und Sozialkunde");

        SubjectCollection subjectCollection = new SubjectCollection();
        subjectCollection.addSubject(subjectPartOne);
        subjectCollection.addSubject(subjectTaskTwo);
        subjectCollection.addSubject(subjectEconomics);

        PartialExamination partialExamination = new PartialExamination();
        partialExamination.setLabel("Teil B");
        partialExamination.setSubjectCollection(subjectCollection);

        return partialExamination;
    }


}
