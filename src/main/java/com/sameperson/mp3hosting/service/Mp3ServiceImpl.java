package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.dao.Mp3Dao;
import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<Mp3> findAllPublic() {
        return mp3Dao.findAllPublic();
    }

    @Override
    public Mp3 findOne(Long id) {
        Mp3 mp3 = mp3Dao.findOne(id);
        if(mp3 == null) {
            throw new Mp3NotFoundException();
        }
        return mp3;
    }

    @Override
    public void save(Mp3 mp3) {
        mp3Dao.save(mp3);
    }

    @Override
    public void save(Mp3 mp3, MultipartFile file) {
        try {
            mp3.setData(file.getBytes());
        } catch (IOException e) {
            //TODO: Add error handling
            e.printStackTrace();
        }
        mp3Dao.save(mp3);
    }
}
