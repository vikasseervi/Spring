//package com.vikas.rest.project.rest;
//
//import com.vikas.rest.project.entity.Employee;
//import com.vikas.rest.project.service.EmployeeService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController {
//    private EmployeeService employeeService;
//    public EmployeeRestController(EmployeeService employeeService){
//        this.employeeService = employeeService;
//    }
//
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//        return employeeService.findAll();
//    }
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId){
//         Employee employee = employeeService.findById(employeeId);
//         if(employee == null) throw new RuntimeException("Employee id not found : "+employeeId);
//         return employee;
//    }
//    // @PostMapping is for creating a new Employee
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee) {
//        // just in case they pass an id in JSON... set id to 0
//        // this is to force a save of new item... instead of update
//        employee.setId(0);
//        return employeeService.save(employee);
//    }
//    // @PutMapping is for updating a Employee
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        return employeeService.save(employee);
//    }
//    @DeleteMapping("/employees/{employeeId}")
//    public String deleteEmployee(@PathVariable int employeeId){
//        Employee employee = employeeService.findById(employeeId);
//        if(employee == null) throw new RuntimeException("Employee id not found : "+employeeId);
//        employeeService.deleteById(employeeId);
//        return "Deleted employee id - "+employeeId;
//    }
//}
