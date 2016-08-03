package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.dao.Mp3Dao;
import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class Mp3ServiceImpl implements Mp3Service {

    @Autowired
    private Mp3Dao mp3Dao;

    @Override
    public List<Mp3> findAll() {
        return mp3Dao.findAll();
    }

    @Override
    public Mp3 findById(Long id) {
        return mp3Dao.findById(id);
    }

    @Override
    public void save(Mp3 mp3, MultipartFile file) {
        mp3Dao.save(mp3);
    }

    @Override
    public void delete(Mp3 mp3) {
        mp3Dao.delete(mp3);
    }
}
