package sample.entity.grade;

import sample.interfaces.GradeInterface;

public class Insufficient implements GradeInterface {
    private int points;

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String getValuation() {
        return "grade.insufficient";
    }

}
