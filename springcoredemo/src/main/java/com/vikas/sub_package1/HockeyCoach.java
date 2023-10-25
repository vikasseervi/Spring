package com.vikas.sub_package1;

import com.vikas.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;
//Gives exception
@Component
public class HockeyCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I am from sub_package1(Hockey Coach)";
    }
}
