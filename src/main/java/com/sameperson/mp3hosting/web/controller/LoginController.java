package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.User;
import com.sameperson.mp3hosting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("heading","Log in");
        return "login/login";
    }

    @RequestMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
