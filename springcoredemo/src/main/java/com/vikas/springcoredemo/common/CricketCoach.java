package com.vikas.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier have high priority than @Primary. @Qualifier is more specific than @Primary. @Primary is selected if there is no @Qualifier
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "<b>Practice fast bowling for 15 minutes";
    }
}
