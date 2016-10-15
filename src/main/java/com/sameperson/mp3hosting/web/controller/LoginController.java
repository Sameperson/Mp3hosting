package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.User;
import com.sameperson.mp3hosting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return null;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login(Model model,  HttpServletRequest request) {
        model.addAttribute("user", new User());
        try {
            Object flash = request.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            request.getSession().removeAttribute("flash");
        } catch (Exception ex) {}
        model.addAttribute("heading","Log in");
        return "login/login";
    }

    @RequestMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
