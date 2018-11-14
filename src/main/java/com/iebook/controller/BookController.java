package com.iebook.controller;

import com.github.pagehelper.PageInfo;
import com.iebook.dao.LogDao;
import com.iebook.entry.Book;
import com.iebook.entry.Log;
import com.iebook.entry.User;
import com.iebook.entry.UserBook;
import com.iebook.service.*;
import com.iebook.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/books")
public class BookController {
    private final String USER_SESSION = "usersession";

    @Value("${web.bookpath}")
    private String bookpath;

    @Autowired
    private UserBookService userBookService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private KindService kindService;
    @Autowired
    private LogService logService;

    @RequestMapping(path = "/homebook")
    public String homeBook (Model model) {
        model.addAttribute("kinds", kindService.listKind());
        return "/book/home_book";
    }

    @RequestMapping(path = "/updateOrSaveBook")
    public String updateOrSaveBook () {
        return "/book/updateOrSaveBook";
    }

    @RequestMapping(path = "/bookform")
    public String bookform (Model model) {
        model.addAttribute("kinds", kindService.listKind());
        return "/book/bookform";
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

        downOrOnline(response, book, true);
    }

    private void downOrOnline(HttpServletResponse response, Book book, boolean flag) {
        byte[] data;
        try {
            String path = this.bookpath + (flag?book.getPath() : book.getPicpath());
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

    @RequestMapping(path = "/onlineread")
    @ResponseBody
    public void onlineread (HttpServletResponse response, @RequestParam("id") String id) throws IOException{
        response.setCharacterEncoding("UTF-8");
        Book book = new Book();
        book.setId(id);
        book.setOnlinecount(1);
        book.setExamine(null);
        logService.saveLog(new Log(id, Constants.ONLINE_DOWN.ONLINE));
        bookService.lineOrDown(book);
        book = bookService.getBook(book);
        downOrOnline(response, book, true);
    }

    @RequestMapping(path = "/picbook")
    @ResponseBody
    public void picbook (HttpServletResponse response, @RequestParam("id") String id) throws IOException{
        Book book = new Book();
        book.setId(id);
        book = bookService.getBook(book);
        downOrOnline(response, book, false);
    }

    @RequestMapping(path = "/editbookform")
    public String editBookForm (Model model, Book book) {
        model.addAttribute("book", bookService.getBook(book));
        model.addAttribute("kinds", kindService.listKind());
        return "/book/editbookform";
    }

    @RequestMapping("/onlinebook")
    public String onlineBook () {
        return "/book/onlinebook";
    }

    @RequestMapping(path = "/saveorupdatebook", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrUpdateBook (HttpSession session, Book book) throws IOException {
        User user = (User) session.getAttribute(USER_SESSION);
        MultipartFile picpathfile = book.getPicpathfile();
        if (picpathfile != null) {
            String filename = picpathfile.getOriginalFilename();
            String dirsPath = this.dirsPath(book.getKind().getId(), filename);
            picpathfile.transferTo(new File(this.bookpath + dirsPath));
            book.setPicpath(dirsPath);
        }
        MultipartFile picpathfile1 = book.getPicpathfile1();
        if (picpathfile1 != null) {
            String filename = picpathfile1.getOriginalFilename();
            String dirsPath = this.dirsPath(book.getKind().getId(), filename);
            picpathfile1.transferTo(new File(this.bookpath + dirsPath));
            book.setPicpath1(dirsPath);
        }
        MultipartFile picpathfile2 = book.getPicpathfile2();
        if (picpathfile2 != null) {
            String filename = picpathfile2.getOriginalFilename();
            String dirsPath = this.dirsPath(book.getKind().getId(), filename);
            picpathfile2.transferTo(new File(this.bookpath + dirsPath));
            book.setPicpath2(dirsPath);
        }
        MultipartFile picpathfile3 = book.getPicpathfile3();
        if (picpathfile3 != null) {
            String filename = picpathfile3.getOriginalFilename();
            String dirsPath = this.dirsPath(book.getKind().getId(), filename);
            picpathfile3.transferTo(new File(this.bookpath + dirsPath));
            book.setPicpath3(dirsPath);
        }

        MultipartFile bookpdf = book.getBookpdf();
        if (bookpdf != null) {
            String bookpdfpath = this.dirsPath(book.getKind().getId(), bookpdf.getOriginalFilename());
            bookpdf.transferTo(new File(this.bookpath + bookpdfpath));
            book.setPath(bookpdfpath);
        }
        book.setExamineuid(book.getExamine() != null ? user.getId() : null);
        book.setUpdateuid(user.getId());
        boolean count = bookService.saveOrUpdateBook(book);
        if (Constants.ExamineCode.PASS == book.getExamine().intValue() || Constants.ExamineCode.NO_PASS == book.getExamine().intValue()) {
            MailSend mailSend = new MailSend();
            final Book book1 = bookService.getBook(book);
            User u = new User();
            u.setId(book1.getUpdateuid());
            final User u2 = userService.getUser(u);
            mailSend.sendMail(book.getExamine(), book1.getName(), u2.getEmail());
        }
        if (count) {
            return new Result("添加成功！", Constants.Code.SUCCESS_CODE, count, null);
        }
        return new Result("添加失败！", Constants.Code.ERROR_CODE, count, null);
    }

    @RequestMapping(path = "/listbook", method = RequestMethod.POST)
    @ResponseBody
    public Result listBook (HttpSession session, int page, int size, Book book) {
        User user  = (User) session.getAttribute(this.USER_SESSION);
        book.setUserid(user.getId());
        PageInfo<Book> pageInfo = bookService.listBookByCondition(page, size, book);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, pageInfo);
    }

    @RequestMapping("/examinebook")
    public String examineBook () {
        return "/book/examinebook";
    }

    @RequestMapping(path = "/examinebookdata")
    @ResponseBody
    public Result examineBookData (int page, int size, Book book) {
        PageInfo<Book> bookPageInfo = bookService.listBookByCondition(page, size, book);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, bookPageInfo);
    }

    private String dirsPath (String kind, String filename) {
        String suffix = filename.substring(filename.lastIndexOf('.'));
        Calendar calendar = Calendar.getInstance();
        String dateTimePath = String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf(calendar.get(Calendar.MONDAY)) + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String suffixPath = File.separator + kind + File.separator + dateTimePath + File.separator;
        File booksFiles = new File(this.bookpath + File.separator + suffixPath);
        if (!booksFiles.exists()) {
            booksFiles.mkdirs();
        }
        return suffixPath + Utils.getUUID() + suffix;
    }

    @RequestMapping(path = "/bookscounts")
    public String bookscounts () {
        return "/book/bookscounts";
    }

    @ResponseBody
    @RequestMapping(path = "/bookscountsmap")
    public Result bookscountsmap (Log log) {
        if (log.getStartdate() == null || log.getEnddate() == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONDAY) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            log.setStartdate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day));
        }
        Map<String, Object> popularBooks = logService.getPopularBooks(log);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, popularBooks);
    }

    @RequestMapping(path = "/favourite")
    public String favourite (Model model) {
        model.addAttribute("kinds", kindService.listKind());
        return "/book/favourite";
    }

    @RequestMapping(path = "/favourite/datas")
    @ResponseBody
    public void favourite(HttpSession session, UserBook userBook) {
         User user = (User) session.getAttribute(this.USER_SESSION);
         userBook.setUserid(user.getId());
         userBook.setFlag(Constants.Code.EXIST_CODE);
        userBookService.saveOrUpdateUserBook(userBook);
    }

    @ResponseBody
    @RequestMapping(path = "/favouritelist")
    public Result favouritelist(HttpSession session, int page, int size, UserBook userBook) {
         User user = (User) session.getAttribute(this.USER_SESSION);
         userBook.setUserid(user.getId());
        PageInfo pageInfo = userBookService.listMyFavourites(page, size, userBook);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, pageInfo);
    }

    @RequestMapping(path = "/mybooks")
    public String mybooks (Model model) {
        model.addAttribute("kinds", kindService.listKind());
        return "/book/mybooks";
    }

    @RequestMapping(path = "/listbookByOwn")
    @ResponseBody
    public Result listbookByOwn (HttpSession session, int page, int size, Book book) {
        User user  = (User) session.getAttribute(this.USER_SESSION);
        book.setUserid(user.getId());
        book.setUpdateuid(user.getId());
        PageInfo<Book> pageInfo = bookService.listBookByCondition(page, size, book);
        return new Result("查询成功！", Constants.Code.SUCCESS_CODE, Boolean.TRUE, pageInfo);
    }
}
