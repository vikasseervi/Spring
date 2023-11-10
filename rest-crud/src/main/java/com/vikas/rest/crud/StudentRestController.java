package com.vikas.rest.crud;
import com.vikas.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> list;

    // define @PostController to load the data only once!
    @PostConstruct
    public void loadData() {
        list = new ArrayList<>();
        list.add(new Student("Vikas", "Seervi"));
        list.add(new Student("Yash", "Prakash"));
        list.add(new Student("Abdul", "Ahad"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check whether student is present or not.
        if(studentId < 0 || studentId >= list.size()){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return list.get(studentId);
    }

    /*

    // Add an Exception Handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        // create a StudentErrorResponse
        StudentErrorResponse error =  new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis() );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        // create a StudentErrorResponse
        StudentErrorResponse error =  new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

     */
    // Moved to StudentRestExceptionHandler ClassC//
}