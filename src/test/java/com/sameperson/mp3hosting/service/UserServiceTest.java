package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.dao.UserDao;
import com.sameperson.mp3hosting.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void loadUserByUsername_shouldReturnOneUser() {
        Mockito.when(userDao.findByUsername("user")).thenReturn(new User());
        Assert.assertThat(userDao.findByUsername("user"), Matchers.instanceOf(User.class));
        Mockito.verify(userDao).findByUsername("user");
    }

}
