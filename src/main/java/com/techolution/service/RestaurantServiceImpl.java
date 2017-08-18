package com.techolution.service;

import com.techolution.model.Menu;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by twanrasagita on 8/18/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public int getMaximumSatisfication(Menu input) {
        int maxSatisfaction = 0;

        if(input != null && !CollectionUtils.isEmpty(input.getDishes())) {
            // create matrix of number of menu items (row) and given time (column)
            int[][] matrix = new int[input.getDishes().size() + 1][input.getGivenTime() + 1];

            for(int item = 0; item <= input.getDishes().size(); item++) {
                for(int currentTime = 0; currentTime <= input.getGivenTime(); currentTime++) {
                    if(item == 0 || currentTime == 0) {

                        // set all rows with 0 if given time is 0 and set all columns with 0 if no menu item to choose from
                        matrix[item][currentTime] = 0;

                    } else if(input.getDishes().get(item - 1).getTimeTaken() <= currentTime) {

                        // if we can afford to include both current item and previous value then find its max value
                        int currentItemPlusPreviousValue = input.getDishes().get(item - 1).getSatisfactionAmt()
                                + matrix[item - 1][currentTime - input.getDishes().get(item - 1).getTimeTaken()];
                        int previousValue = matrix[item - 1][currentTime];

                        matrix[item][currentTime] = Math.max(currentItemPlusPreviousValue, previousValue);

                        if(matrix[item][currentTime] > maxSatisfaction) {
                            maxSatisfaction = matrix[item][currentTime];

                        }
                    } else {

                        // if we can't afford to add up with remaining time taken then carry forward the value
                        matrix[item][currentTime] = matrix[item - 1][currentTime];
                    }
                }
            }
        }

        return maxSatisfaction;
    }
}
