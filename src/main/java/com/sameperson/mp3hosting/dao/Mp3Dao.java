package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.data.repository.CrudRepository;

public interface Mp3Dao extends CrudRepository<Mp3, Long> {

}
