package com.techolution.service;

import com.techolution.model.Dish;
import com.techolution.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twanrasagita on 8/18/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceImplTest {
    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    @Test
    public void getMaximumSatisfication_withNullInput() {
        int maxSatisfaction = restaurantService.getMaximumSatisfication(null);

        assertThat(maxSatisfaction, is(0));
    }

    @Test
    public void getMaximumSatisfication_withInputWithinMaxGivenTime() {
        Dish dish1 = new Dish(5000, 50);
        Dish dish2 = new Dish(2500, 40);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        dishes.add(dish2);

        Menu input = new Menu();
        input.setGivenTime(100);
        input.setDishes(dishes);

        int maxSatisfaction = restaurantService.getMaximumSatisfication(input);

        assertThat(maxSatisfaction, is(7500));
    }

    @Test
    public void getMaximumSatisfication_withInputExceedMaxGivenTime1() {
        Dish dish1 = new Dish(3000, 80);
        Dish dish2 = new Dish(2500, 60);
        Dish dish3 = new Dish(1000, 20);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);

        Menu input = new Menu();
        input.setGivenTime(100);
        input.setDishes(dishes);

        int maxSatisfaction = restaurantService.getMaximumSatisfication(input);

        assertThat(maxSatisfaction, is(4000));
    }

    @Test
    public void getMaximumSatisfication_withInputExceedMaxGivenTime2() {
        Dish dish1 = new Dish(5000, 80);
        Dish dish2 = new Dish(2500, 50);
        Dish dish3 = new Dish(1000, 50);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);

        Menu input = new Menu();
        input.setGivenTime(100);
        input.setDishes(dishes);

        int maxSatisfaction = restaurantService.getMaximumSatisfication(input);

        assertThat(maxSatisfaction, is(5000));
    }
}