package com.vikas;

import com.vikas.dao.StudentDAO;
import com.vikas.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			 createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Yash", "Prakash", "yash@zyx.com");
		// save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(student);
		// display if of the saved student
		System.out.println("Saved student. Generated id: "+ student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Vikas", "Seervi", "vv3242@xyz.com");
		// save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(student);
		// display if of the saved student
		int id = student.getId();
		System.out.println("Saved student. Generated id: "+ id);
		// retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: "+id);
		Student tempStudent = studentDAO.findById(id);
		// display student
		System.out.println("Found the student: "+tempStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();
		// display list of students
		for(Student student : students) System.out.println(student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("ahad");
		// display list of students
		for(Student student : students) System.out.println(student);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieving student by ID
		Integer id = 1;
		System.out.println("Getting student with id: "+id);
		Student tempStudent = studentDAO.findById(id);
		System.out.println("Updating student...");
		// changing the first name
		tempStudent.setFirstName("Nikku");
		studentDAO.update(tempStudent);
		// displaying the updated student
		System.out.println("Updated student: "+tempStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer id = 3;
		System.out.println("Deleting student id: "+id);
		studentDAO.delete(id);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + numRowsDeleted);
	}
}
