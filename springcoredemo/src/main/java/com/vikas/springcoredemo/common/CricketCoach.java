package com.vikas.springcoredemo.common;

import jdk.jfr.Label;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
// @Lazy components are instantiated only when requested or when needed. We can also do this on global scale by writing some code in properties file
/*@Lazy*/
/*@Primary*/
// @Qualifier have high priority than @Primary. @Qualifier is more specific than @Primary. @Primary is selected if there is no @Qualifier
/*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/   // Prototype beans are lazy by default.
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<b>Practice fast bowling for 15 minutes";
    }

    @GetMapping("/vikas")
    public String vikas() {
        return "<h3> I'm called directly from component class(CricketCoach) </h3>";
    }
}


