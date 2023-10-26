package com.vikas.springcoredemo.config;

import com.vikas.springcoredemo.common.Coach;
import com.vikas.springcoredemo.rest.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    /*@Bean
    public Coach swimCoach() {  //Here swimCoach(method name) is the Bean ID.
        return new SwimCoach();
    }*/

    @Bean("aquatic")
    public Coach swimCoach() { //Here we are giving custom Bean ID to the Bean
        return new SwimCoach();
    }
}
