package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.Mp3;
import com.sameperson.mp3hosting.service.Mp3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mp3Controller {
    @Autowired
    private Mp3Service mp3Service;


    // UPLOAD new Mp3

    @RequestMapping("/upload")
    public String formUploadMp3(Model model) {
        if(!model.containsAttribute("mp3")) {
            model.addAttribute("mp3", new Mp3());
        }
        model.addAttribute("action","/mp3s");
        model.addAttribute("heading","Upload");
        model.addAttribute("submit","Add");
        return "mp3/form";
    }


}
