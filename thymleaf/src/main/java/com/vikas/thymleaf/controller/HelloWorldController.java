package com.vikas.thymleaf.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @PostMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // new controller method to read data and add data to the model
    @RequestMapping("/processFormVersion2")
    public String letsShoutTheName(HttpServletRequest request, Model model){
        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        // create the message
        String  result = "YO! " + name;

        // add message to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }

    @RequestMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();

        // create the message
        String  result = "HI MF!!! " + name;

        // add message to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }
}
