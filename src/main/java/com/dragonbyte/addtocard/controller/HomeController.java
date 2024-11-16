package com.dragonbyte.addtocard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public String getUserInfo(){
        return "Hello!!";
    }
}
