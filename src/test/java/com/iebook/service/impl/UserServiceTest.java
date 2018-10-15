package com.iebook.service.impl;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.User;
import com.iebook.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void listUserTest() {
        PageInfo pageInfo = userService.listUser(1,1);
        System.out.println(pageInfo);
    }

    @Test
    public void getUserTest() {
        User user = new User();
        user.setId("1");
        user = userService.getUser(user);
        System.out.println(user);
    }

    @Test
    public void listUserByConditionTest () {
        User user = new User();
        user.setName("la1");
        PageInfo pageInfo = userService.listUserByCondition(user);
        System.out.println(pageInfo);
    }

    @Test
    public void saveOrUpdateUser () {
        User user = new User();
        user.setId("1");
        user.setName("update");
        user.setPower(1);
        user.setFlag(1);
        user.setUpdatedate(new Date());
        Assert.assertTrue("return true add or update success", userService.saveOrUpdateUser(user));
        user.setId(null);
        user.setName("save");
        user.setCreatedate(new Date());
        Assert.assertTrue("return true add or update success", userService.saveOrUpdateUser(user));
    }
}