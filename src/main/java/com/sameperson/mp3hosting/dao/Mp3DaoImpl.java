package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.Mp3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Mp3DaoImpl implements Mp3Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Mp3> findAll() {
        Session session = sessionFactory.openSession();
        List<Mp3> mp3s = session.createCriteria(Mp3.class).list();
        session.close();
        return mp3s;
    }

    @Override
    public Mp3 findById(Long id) {
        Session session = sessionFactory.openSession();
        Mp3 mp3 = session.get(Mp3.class, id);
        session.close();
        return mp3;
    }

    @Override
    public void save(Mp3 mp3) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mp3);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Mp3 mp3) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(mp3);
        session.getTransaction().commit();
        session.close();
    }
}
