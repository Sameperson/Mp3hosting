package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService{
    User findByUsername(String username);
    void save(User user);
}
