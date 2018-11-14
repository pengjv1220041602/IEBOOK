package com.iebook.controller;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;
import com.iebook.entry.User;
import com.iebook.service.BookService;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:18
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final String USER_SESSION = "usersession";
    @Value("${web.photo}")
    private String photoFile;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/home")
    public String user () {
        return "/user/";
    }

    @RequestMapping(path = "/userlisthtml")
    public String userListHtml () {
        return "/user/userlist";
    }

    @RequestMapping(path = "/updatepassword")
    public String updatePassword () {
        return "/user/updatepassword";
    }

    @RequestMapping(path = "/userlist")
    @ResponseBody
    public Result userlist (int page, int size) {
        PageInfo pageInfo = userService.listUser(page, size);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, pageInfo);
    }

    @RequestMapping(path = "/saveorupdateuser")
    @ResponseBody
    public Result saveorupdateuser(HttpSession session, @RequestParam(required = false, defaultValue = "false") boolean loginInfo, User user){
        return saveAndUpdateTogether(user);
    }

    @RequestMapping(path = "/updatePassword")
    @ResponseBody
    public Result updatePassword (HttpSession session, String oldPassword, String newPassword) {
        User sessionUser = (User)session.getAttribute(USER_SESSION);
        User dbUser = userService.getUser(sessionUser);
        if (dbUser != null && dbUser.getPassword().equals(oldPassword)) {
            dbUser.setPassword(newPassword);
            return saveAndUpdateTogether(dbUser);
        }
        return new Result("修改失败！", Constants.Code.ERROR_CODE, Boolean.FALSE, null);
    }

    private Result saveAndUpdateTogether (User user) {
        if (userService.saveOrUpdateUser(user)) {
            return new Result("修改成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, null);
        }
        return new Result("修改失败！", Constants.Code.ERROR_CODE, Boolean.FALSE, null);
    }

    @RequestMapping(path = "/userbooks")
    public String usersbook () {
        return "/user/userbooks";
    }

    @GetMapping("/photo")
    public void photo (HttpServletResponse response, HttpSession session) {
        final  User user= (User)session.getAttribute(this.USER_SESSION);
        downOrOnline(response, user);
    }
    private void downOrOnline(HttpServletResponse response, User user) {
        byte[] data;
        try {
            String path = this.photoFile + user.getPhoto();
            File file = new File(path);
            FileInputStream input = new FileInputStream(file);
            data = new byte[input.available()];
            input.read(data);
            response.getOutputStream().write(data);
            input.close();
        } catch (Exception e) {
            System.out.print("pdf文件处理异常：" + e.getMessage());
        }
    }
    @PostMapping("/logout")
    @ResponseBody
    public Boolean logout(HttpSession session) {
        session.removeAttribute(this.USER_SESSION);
        return true;
    }
}
