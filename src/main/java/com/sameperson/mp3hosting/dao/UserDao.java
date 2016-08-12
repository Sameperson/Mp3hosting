package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    User findByUsername(String username);
}

