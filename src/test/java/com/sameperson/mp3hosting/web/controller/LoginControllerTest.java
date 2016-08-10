package com.sameperson.mp3hosting.web.controller;

import com.sameperson.mp3hosting.model.User;
import com.sameperson.mp3hosting.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private LoginController loginController;
    @Mock
    private UserService userService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void loginPage_shouldIncludeUserAndHeader() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(view().name("login/login"))
                .andExpect(model().attribute("user", Matchers.instanceOf(User.class)));
    }
}
