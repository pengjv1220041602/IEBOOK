package com.iebook.controller;

import com.iebook.entry.User;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ZhPJ
 * @Date 2018/10/16 00169:53
 * @Version 1.0
 * @Description:
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String loginHtml () {
        return "login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin (User user) {
        try {
            user = userService.login(user);
            if (user != null) {
                return new Result("success", Constants.Code.SUCCESS_CODE, Boolean.TRUE, user);
            }
        } catch (Exception e) {
            return  new Result("exception", Constants.Code.EXCEPTION_CODE, Boolean.FALSE, null);
        }
        return new Result("error", Constants.Code.ERROR_CODE, Boolean.FALSE,null);
    }

    @RequestMapping(path = {"/nav", ""}, method = RequestMethod.GET)
    public String home () {
        return "/home/nav";
    }

    @RequestMapping(path = "/main")
    public String main (Model model) {
        return "/home/main";
    }
}
