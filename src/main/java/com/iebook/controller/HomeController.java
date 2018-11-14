package com.iebook.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;
import com.iebook.entry.Log;
import com.iebook.entry.User;
import com.iebook.service.BookService;
import com.iebook.service.LogService;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import com.iebook.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * @Author ZhPJ
 * @Date 2018/10/16 00169:53
 * @Version 1.0
 * @Description:
 */
@Controller
public class HomeController {
    private final String USER_SESSION = "usersession";
    @Value("${web.photo}")
    private String photoFile;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Autowired
    private LogService logService;


    @Value("${web.bookpath}")
    private String picpath;

    @RequestMapping(value = "/login")
    public String loginHtml () {
        return "/login";
    }

    @RequestMapping(value = "/viCode")
    public void viCode (HttpServletResponse response, HttpSession session) throws IOException {
        final String s = VerifyCodeUtils.outputVerifyImage(100, 35, response.getOutputStream(), 4);
        session.setAttribute("code", s);
    }

    @RequestMapping(path = {"index","/"})
    public String index (Book book, Model model) {
        Random random = new Random();
        int i = random.nextInt();
        int page = i > 20 ? 1 : i;
        book.setExamine(Constants.ExamineCode.PASS);
        PageInfo<Book> pageInfo = bookService.listBookByCondition(page, 30, book);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("name", book.getName());
        return "/index";
    }

    @RequestMapping(path = "/bookpic/{id}/{flag}")
    @ResponseBody
    public void index (HttpServletResponse response, @PathVariable("id") String id, @PathVariable("flag") Integer flag,  Model model) {
        Book book = new Book();
        book.setId(id);
        book = bookService.getBook(book);
        downOrOnline(response, book, flag );
    }
    private void downOrOnline(HttpServletResponse response, Book book, int flag) {
        byte[] data;
        try {
            String path = "";//this.picpath + (flag?book.getPath() : book.getPicpath());
            if (flag == 0) {
                path = this.picpath +  book.getPicpath();
            } else if (flag == 1){
                path = this.picpath + book.getPicpath1();
            } else if (flag == 2) {
                path = this.picpath + book.getPicpath2();
            } else if (flag == 3) {
                path = this.picpath + book.getPicpath3();
            } else if (flag == 4) {
                path = this.picpath + book.getPath();
            }
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


    @RequestMapping(path = "/downbooks")
    public void downbooks (HttpServletResponse response, @RequestParam("id") String id) throws IOException {
        Book book = new Book();
        book.setId(id);
        book.setDowncount(1);

        logService.saveLog(new Log(id, Constants.ONLINE_DOWN.DOWN));
        bookService.lineOrDown(book);
        book = bookService.getBook(book);

        response.setContentType("*/* ");
        response.setHeader("Connection", "close"); // 表示不能用浏览器直接打开
        response.setHeader("Accept-Ranges", "bytes");// 告诉客户端允许断点续传多线程连接下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String((book.getName() + ".pdf").getBytes("UTF-8"), "ISO8859-1"));
        response.setCharacterEncoding("UTF-8");

        downOrOnline(response, book, 4);
    }
    @RequestMapping("/onlinebook")
    public String onlineBook () {
        return "/book/onlinebook";
    }
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin (HttpSession session, User user) {
        String code = (String)session.getAttribute("code");

        try {
            if (!code.equalsIgnoreCase(user.getCode())) {
                return new Result("验证码错误", Constants.Code.ERROR_CODE, Boolean.FALSE, user);
            }
            user = userService.login(user);
            if (user != null) {
                session.setAttribute(USER_SESSION, user);
                session.setAttribute("power", user.getPower());
                setSession(session, user);
                return new Result("success", Constants.Code.SUCCESS_CODE, Boolean.TRUE, user);
            }
        } catch (Exception e) {
            return  new Result("用户名或密码错误", Constants.Code.EXCEPTION_CODE, Boolean.FALSE, null);
        }
        return new Result("用户名或密码错误", Constants.Code.ERROR_CODE, Boolean.FALSE,null);
    }

    @RequestMapping(path = "/saveuser")
    @ResponseBody
    public Result saveuser(HttpSession session,
                           @RequestParam(required = false, defaultValue = "false") boolean loginInfo, User user) throws IOException {
        String filename = user.getPhfile().getOriginalFilename();
        String substring = filename.substring(filename.lastIndexOf("."));
        final String s = UUID.randomUUID() + substring;
        final File file = new File(photoFile);
        if (!file.exists()) {
            file.mkdirs();
        }
        user.getPhfile().transferTo(new File(photoFile + s));
        user.setPhoto(s);
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

    @RequestMapping(path = "/nav", method = RequestMethod.GET)
    public String home () {
        return "/home/nav";
    }

    @RequestMapping(path = {"/main"})
    public String main (Model model) {
        return "/home/main";
    }

    @RequestMapping("/bookdetail/{id}")
    public String bookdetail (HttpServletResponse response, Model model, @PathVariable("id") String id) {
        Book book = new Book();
        book.setId(id);
        book = bookService.getBook(book);
        model.addAttribute("book", book);
        return "/details";
    }

    @RequestMapping(path = "/regist")
    public String regist () {
        return "/regist";
    }
}
