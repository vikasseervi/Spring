package com.vikas.mvc;

import com.vikas.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is mandatory")
    @Size(min = 1, message = "is mandatory")
    private String firstName;
    private String lastName;
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be >= 1")
    @Max(value = 200, message = "must be <= 200")
    private Integer age;
    @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "only 5 characters/digits")
    private String postalCode;
    @CourseCode(value = "ANU", message = "must start with ANU") // can also update by passing parameters
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
