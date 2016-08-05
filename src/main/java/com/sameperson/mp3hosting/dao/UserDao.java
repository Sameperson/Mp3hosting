package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    void save(User category);
    void delete(User category);
}
