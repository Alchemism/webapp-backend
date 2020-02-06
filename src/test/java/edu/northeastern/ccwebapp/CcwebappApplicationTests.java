package edu.northeastern.ccwebapp;

import edu.northeastern.ccwebapp.controller.BookController;
import edu.northeastern.ccwebapp.pojo.User;
import edu.northeastern.ccwebapp.repository.BookRepository;
import edu.northeastern.ccwebapp.repository.UserRepository;
import edu.northeastern.ccwebapp.service.BookService;
import edu.northeastern.ccwebapp.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = BookController.class, secure = false)
public class CcwebappApplicationTests {

    private User user;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Mock
    UserRepository userRepository;

    @MockBean
    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    @Test
    public void emailChecker() {
        User user = new User();
        user.setUsername("qwert@gmail.com");
        user.setPassword("4ar@@@@@@");

        Mockito.when(userService.findByUserName(Mockito.anyString())).thenReturn(user);
        String testName = userService.findByUserName("qwert@gmail.com").getUsername();
        Assert.assertEquals("qwert@gmail.com", testName);
    }
}