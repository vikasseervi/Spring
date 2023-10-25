package com.vikas.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(
		scanBasePackages = {"com.vikas.sub_package1",
				"com.vikas.springcoredemo"}
)
//@SpringBootApplication()
public class SpringcoredemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}

//In this we have moved the Coach Interface and other classes in other subpackages to see that Spring can scan subpackages for component, which it does
