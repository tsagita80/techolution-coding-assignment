package com.techolution.model;

/**
 * Created by twanrasagita on 8/18/17.
 */
public class Dish {
    private int satisfactionAmt;
    private int timeTaken;

    public Dish() {
    }

    public Dish(int satisfactionAmt, int timeTaken) {
        this.satisfactionAmt = satisfactionAmt;
        this.timeTaken = timeTaken;
    }

    public int getSatisfactionAmt() {
        return satisfactionAmt;
    }

    public void setSatisfactionAmt(int satisfactionAmt) {
        this.satisfactionAmt = satisfactionAmt;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
