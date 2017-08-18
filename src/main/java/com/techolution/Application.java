package com.techolution;

import com.techolution.model.Menu;
import com.techolution.service.RestaurantService;
import com.techolution.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by twanrasagita on 8/18/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private RestaurantService restaurantService;

    public static void main (String [] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length == 0) {
            System.out.println("Pleave provide input, e.g. data.txt");
        } else {
            Menu menu = fileUtil.extractInputFromFile(args[0]);
            int maxSatisfaction = restaurantService.getMaximumSatisfication(menu);

            System.out.println("*********** Maximum satisfaction ********** : " + maxSatisfaction);
        }
    }
}
