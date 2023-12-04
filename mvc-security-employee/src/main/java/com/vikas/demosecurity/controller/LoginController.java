package com.vikas.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        // return "login";
        return "fancy-login";
    }

    // add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDinedPage(){
        return "access-denied";
    }
}
