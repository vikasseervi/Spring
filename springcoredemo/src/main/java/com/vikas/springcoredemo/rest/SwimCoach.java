package com.vikas.springcoredemo.rest;

import com.vikas.springcoredemo.common.Coach;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<i><b>Swim 1000 meters daily";
    }
}
