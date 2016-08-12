package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.Mp3;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mp3Dao extends CrudRepository<Mp3, Long> {
    @Query("select a from Mp3 a where a.user.id=:#{principal.id}")
    List<Mp3> findAll();
}
