package com.iebook.controller;

import com.iebook.entry.User;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author ZhPJ
 * @Date 2018/10/16 00169:53
 * @Version 1.0
 * @Description:
 */
@Controller
public class HomeController {
    private final String USER_SESSION = "usersession";
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String loginHtml () {
        return "/login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin (HttpSession session, User user) {
        try {
            user = userService.login(user);
            if (user != null) {
                session.setAttribute(USER_SESSION, user);
                session.setAttribute("power", user.getPower());
                setSession(session, user);
                return new Result("success", Constants.Code.SUCCESS_CODE, Boolean.TRUE, user);
            }
        } catch (Exception e) {
            return  new Result("exception", Constants.Code.EXCEPTION_CODE, Boolean.FALSE, null);
        }
        return new Result("error", Constants.Code.ERROR_CODE, Boolean.FALSE,null);
    }

    @RequestMapping(path = "/saveuser")
    @ResponseBody
    public Result saveuser(HttpSession session, @RequestParam(required = false, defaultValue = "false") boolean loginInfo, User user){
        if (userService.saveUser(user)) {
            return new Result("修改成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, null);
        }
        return new Result("修改失败！", Constants.Code.ERROR_CODE, Boolean.FALSE, null);
    }
    
    @RequestMapping(path = "/setSession", method = RequestMethod.POST)
    @ResponseBody
    private static Result setSession (HttpSession session, User user) {
    	//session.setAttribute("power", user.getPower());
    	System.out.println("session:" + session.getAttribute("power"));
    	return new Result("success", Constants.Code.SUCCESS_CODE, Boolean.TRUE, session.getAttribute("power"));
    }

    @RequestMapping(path = {"/nav", ""}, method = RequestMethod.GET)
    public String home () {
        return "/home/nav";
    }

    @RequestMapping(path = "/main")
    public String main (Model model) {
        return "/home/main";
    }

    @RequestMapping(path = "/regist")
    public String regist () {
        return "/regist";
    }
}
