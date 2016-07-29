package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.service.Mp3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private Mp3Service mp3Service;

    @RequestMapping("/")
    public String home() {
        return "home";
    }



}
