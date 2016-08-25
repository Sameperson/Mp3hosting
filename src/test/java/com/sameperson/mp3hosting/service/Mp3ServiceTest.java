package com.sameperson.mp3hosting.service;

import com.sameperson.mp3hosting.dao.Mp3Dao;
import com.sameperson.mp3hosting.model.Mp3;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Mp3ServiceTest {
    @Mock
    private Mp3Dao mp3Dao;
    @InjectMocks
    private Mp3Service mp3Service = new Mp3ServiceImpl();

    @Test
    public void findAll_ShouldReturnThree() {
        List<Mp3> mp3s = Arrays.asList(
                new Mp3(),
                new Mp3(),
                new Mp3()
        );
        Mockito.when(mp3Dao.findAll()).thenReturn(mp3s);
        Assert.assertEquals("findAll in Mp3Service should return 3 mp3s", 3, mp3Service.findAll().size());
        Mockito.verify(mp3Dao).findAll();
    }

    @Test
    public void findOne_ShouldReturnOne() {
        Mockito.when(mp3Dao.findOne(1L)).thenReturn(new Mp3());
        Assert.assertThat(mp3Service.findOne(1L), Matchers.instanceOf(Mp3.class));
        Mockito.verify(mp3Dao).findOne(1L);
    }

}
