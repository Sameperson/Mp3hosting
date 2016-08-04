package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("heading","Log in");
        return "login/login";
    }

}
