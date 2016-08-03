package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.Mp3;
import com.sameperson.mp3hosting.service.Mp3Service;
import com.sameperson.mp3hosting.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Mp3Controller {
    @Autowired
    private Mp3Service mp3Service;


    // UPLOADING FORM

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

    // UPLOAD NEW Mp3

    @RequestMapping(value = "/mp3s", method = RequestMethod.POST)
    public String addGif(Mp3 mp3, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        mp3Service.save(mp3, file);
        redirectAttributes.addFlashAttribute("flash",new FlashMessage("Mp3 successfully uploaded", FlashMessage.Status.SUCCESS));
        return String.format("redirect:/mp3s/%s", mp3.getId());
    }

}
