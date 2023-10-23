package com.vikas.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/" that return value
    @GetMapping("/")
    public String hello(){
        return "<h1>Hello</h1>";
    }

    @GetMapping("/workout")
    public String workout(){
        return "Daily run 1KM";
    }

    @GetMapping("/msg")
    public String msg(){
        return "<h3>getting message</h3>";
    }

    // Injecting properties form application.properties to variables here!
    @Value("${student.id}") private String studentId;
    @Value("${student.name}") private String studentName;
    @Value("${teacher.name}") private String teacherName;

    @GetMapping("/injectables")
    public String injectedValues() {
        return " <b>  Student ID: "+studentId+"<br>"
                +"Student : "+studentName+"<br>"
                +"Teacher : "+teacherName;
    }

}








//
//    Hello Manan, when we use @RestController annotation we mark a specific class that will trigger a specific method depending on the URL that we visit in our browser.
//
//        This is a basic look of a controller
//
//@RestController <------ explanation 1.
//public class FunRestController {
//
//    // expose "/" that return "Hello World"
//
//    @GetMapping("/")
//    public String sayHello() {
//        return "Hello World!";
//    }
//    Explanation 1 :
//    Since we did not define anything under @RestController, the default value will be placed in that spot.
//    So even if you do not define anything
//            or
//
//    You define
//    @RequestMapping("/")  under your @RestController annotation, Spring looks at it completely the same.
//
//            So:
//
//    @RestController
//    public class FunRestController {
//            =
//
//        @RestController
//        @RequestMapping("/")
//        public class FunRestController {
//            Now, there are two types of Mappings in controller.
//            One is a parent mapping ( The one from the above that goes under the @RestController annotation )
//            Second is child mapping ( The one that goes above a method )
//
//            So for an example
//
//            If you have a class like this
//
//            @RestController
//            public class FunRestController {
//
//                // expose "/" that return "Hello World"
//
//                @GetMapping("/")
//                public String sayHello() {
//                    return "Hello World!";
//                }
//                When you visit http://localhost:8080/  in your browser, that will trigger sayHello() method.
//                There is also a different approach when you have some values in your RequestMapping.
//
//                @RestController
//                @RequestMapping("/rest")
//                public class FunRestController {
//
//                    // expose "/" that return "Hello World"
//
//                    @GetMapping("/")
//                    public String sayHello() {
//                        return "Hello World!";
//                    }
//                    Since we have our parent mapping value of /rest
//                    If we try to visit
//
//                    http://localhost:8080/  we will get 404, because we do not have that mapping handled in our controller.
//                    What we do have is this
//
//                    http://localhost:8080/rest  will trigger our sayHello() method.
//
//                    Or something like this
//
//                    @RestController
//                    @RequestMapping("/rest")
//                    public class FunRestController {
//
//                        // expose "/" that return "Hello World"
//
//                        @GetMapping("/hello")
//                        public String sayHello() {
//                            return "Hello World!";
//                        }
//                        http://localhost:8080/  we will get 404, because we do not have that mapping handled in our controller.
//
//                        http://localhost:8080/rest  we will get 404, because we do not have that mapping handled in our controller.
//
//                        http://localhost:8080/rest/hello  will trigger our sayHello() method.