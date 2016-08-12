package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Mp3Service {
    Iterable<Mp3> findAll();
    Mp3 findOne(Long id);
    void save(Mp3 task);
    void save(Mp3 mp3, MultipartFile file);
}
