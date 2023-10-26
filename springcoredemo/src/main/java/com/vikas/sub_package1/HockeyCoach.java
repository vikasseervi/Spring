package com.vikas.sub_package1;

import com.vikas.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
// ConfigurableBeanFactory.SCOPE_PROTOTYPE => creates new object instances for each injection.
// By default, it's SCOPE_SINGLETON which means multiple objects are pointed to single instance.
/*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/   // Prototype beans are lazy by default.
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    // defining our init method
    /*@PostConstruct
    public  void doMyStartUpStuff() {
        System.out.println("In DoMyStartUpStuff(): "+getClass().getSimpleName());
    }*/
    // defining our destroy method
    /*@PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("In doMyCleanUpStuff(): "+getClass().getSimpleName());
    }*/
    @Override
    public String getDailyWorkout() {
        return "I am from sub_package1(Hockey Coach)";
    }
}
