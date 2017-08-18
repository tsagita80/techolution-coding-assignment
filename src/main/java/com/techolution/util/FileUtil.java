package com.techolution.util;

import com.techolution.model.Dish;
import com.techolution.model.Menu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by twanrasagita on 8/18/17.
 */
@Component
public class FileUtil {
    public Menu extractInputFromFile(String input) throws FileNotFoundException {
        File file = new File(input);
        Scanner sc = new Scanner(file);

        Menu menu = new Menu();

        int totalMenuItems = 0;
        int idx = 0;
        List<Dish> dishes = new ArrayList<>();

        while (sc.hasNextLine()) {
            if(idx == 0) {
                String[] firstLine = StringUtils.split(sc.nextLine(), " ", 2);
                menu.setGivenTime(Integer.parseInt(firstLine[0]));
                totalMenuItems = Integer.parseInt(firstLine[1]);

            } else {
                String[] nextLine = StringUtils.split(sc.nextLine(), " ", 2);
                dishes.add(new Dish(Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1])));
            }

            idx++;
        }

        if(totalMenuItems == dishes.size()) {
            menu.setDishes(dishes);

            return menu;
        }

        throw new RuntimeException("Number of menu items is not match. Please check your input.");
    }
}
