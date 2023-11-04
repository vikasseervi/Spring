package com.vikas.cruddemo;

import com.vikas.cruddemo.dao.StudentDAO;
import com.vikas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Vikas", "Seervi", "vv3242@xyz.com");
		// save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(student);
		// display if of the saved student
		System.out.println("Saved student. Generated id: "+ student.getId());
	}

}
