package com.sameperson.mp3hosting.dao;

import com.sameperson.mp3hosting.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createCriteria(User.class).list();
        session.close();
        return userList;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        //TODO: Implement findByUsername method
        return null;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        System.out.println(String.format("Saving user %s...", user.getUsername()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        System.out.println(String.format("Deleting user %s...", user.getUsername()));
        session.getTransaction().commit();
        session.close();
    }
}
