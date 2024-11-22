package com.aaradhya.acedmiaerpbackend.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminController {


    @RequestMapping("/")
    public String greet() {
        return "Hello World!";
    }


}
