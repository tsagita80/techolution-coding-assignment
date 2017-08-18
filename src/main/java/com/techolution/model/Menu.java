package com.techolution.model;

import java.util.List;

/**
 * Created by twanrasagita on 8/18/17.
 */
public class Menu {
    private int givenTime;
    private List<Dish> dishes;

    public int getGivenTime() {
        return givenTime;
    }

    public void setGivenTime(int givenTime) {
        this.givenTime = givenTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
