package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    void save(User user);
    void delete(User user);
}
