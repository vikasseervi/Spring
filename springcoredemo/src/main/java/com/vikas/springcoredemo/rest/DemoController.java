package com.vikas.springcoredemo.rest;

import com.vikas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    //@Autowired seeks for an appropriate class for the Coach(Interface)
    //It also tells Spring to inject a dependency
    //If we have only one constructor then @Autowired on constructor is optional

    // -> This is call Constructor Injection
    @Autowired
    public DemoController(@Qualifier("hockeyCoach") Coach theCoach) {
        myCoach = theCoach;
    }


    // This is called Setter Injection
    /*
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
     */
    @GetMapping("/dailyworkout")
    public  String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
