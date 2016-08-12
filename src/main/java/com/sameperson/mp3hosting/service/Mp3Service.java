package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Mp3Service {
//    List<Mp3> findAll();
//    Mp3 findById(Long id);
    void save(Mp3 mp3, MultipartFile file);
//    void delete(Mp3 mp3);
}
