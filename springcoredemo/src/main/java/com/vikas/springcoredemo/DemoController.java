package com.vikas.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private  Coach mycoach;
    //@Autowired seeks for an appropriate class for the Coach(Interface)
    //It also tells Spring to inject a dependency
    //If we have only one constructor then @Autowired on constructor is optional
    @Autowired
    public DemoController(Coach theCoach) {
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public  String getDailyWorkout() {
        return mycoach.getDailyWorkout();
    }
}
