package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.Mp3;
import com.sameperson.mp3hosting.service.Mp3Service;
import com.sameperson.mp3hosting.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Mp3Controller {
    @Autowired
    private Mp3Service mp3Service;

    @RequestMapping("/")
    public String listMp3s(Model model) {
        List<Mp3> mp3s = mp3Service.findAll();
        model.addAttribute("mp3s", mp3s);
        return "mp3/index";
    }

    @RequestMapping("/mp3s/{mp3Id}.mp3")
    @ResponseBody
    public byte[] mp3(@PathVariable Long mp3Id) {
        return mp3Service.findOne(mp3Id).getData();
    }

    @RequestMapping("/audio/{audioId}")
    public String mp3Details(@PathVariable Long audioId, Model model) {
        Mp3 mp3 = mp3Service.findOne(audioId);
        model.addAttribute("mp3", mp3);
        return "mp3/details";
    }

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

    @RequestMapping(value = "/mp3s", method = RequestMethod.POST)
    public String addGif(Mp3 mp3, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        mp3Service.save(mp3, file);
        redirectAttributes.addFlashAttribute("flash",new FlashMessage("Mp3 successfully uploaded", FlashMessage.Status.SUCCESS));
        return "redirect:/";
//        return String.format("redirect:/mp3s/%s", mp3.getId());
    }

}