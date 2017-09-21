package sample.model;

import sample.interfaces.GradeInterface;

public class Grade implements GradeInterface {

    private int points;
    private String valuation;

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
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }
}
