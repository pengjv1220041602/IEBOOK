package com.iebook.service.impl;

import com.iebook.entry.User;
import com.iebook.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void getUserTest() {
        User user = userService.getUser("1");
        System.out.println(user);
    }


}