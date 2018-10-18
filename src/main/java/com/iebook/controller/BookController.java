package com.iebook.controller;

import com.github.pagehelper.PageInfo;
import com.iebook.entry.Book;
import com.iebook.entry.Log;
import com.iebook.service.BookService;
import com.iebook.service.KindService;
import com.iebook.service.LogService;
import com.iebook.service.UserService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import com.iebook.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001512:19
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Value("${web.bookpath}")
    private String bookpath;

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
        bookService.saveOrUpdateBook(book);
        book = bookService.getBook(book);

        response.setContentType("*/* ");
        response.setHeader("Connection", "close"); // 表示不能用浏览器直接打开
        response.setHeader("Accept-Ranges", "bytes");// 告诉客户端允许断点续传多线程连接下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String((book.getName() + ".pdf").getBytes("UTF-8"), "ISO8859-1"));
        response.setCharacterEncoding("UTF-8");

        downOrOnline(response, book);
    }

    private void downOrOnline(HttpServletResponse response, Book book) {
        byte[] data;
        try {
            String path = this.bookpath + book.getPath();
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

        logService.saveLog(new Log(id, Constants.ONLINE_DOWN.ONLINE));
        bookService.saveOrUpdateBook(book);
        book = bookService.getBook(book);
        downOrOnline(response, book);
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
    public Result saveOrUpdateBook (Book book) throws IOException {

        MultipartFile picpathfile = book.getPicpathfile();
        if (picpathfile != null) {
            String filename = picpathfile.getOriginalFilename();
            String dirsPath = this.dirsPath(book.getKind().getId(), filename);
            picpathfile.transferTo(new File(this.bookpath + dirsPath));
            book.setPicpath(dirsPath);
        }

        MultipartFile bookpdf = book.getBookpdf();
        if (bookpdf != null) {
            String bookpdfpath = this.dirsPath(book.getKind().getId(), bookpdf.getOriginalFilename());
            bookpdf.transferTo(new File(this.bookpath + bookpdfpath));
            book.setPath(bookpdfpath);
        }
        boolean count = bookService.saveOrUpdateBook(book);
        if (count) {
            return new Result("添加成功！", Constants.Code.SUCCESS_CODE, count, null);
        }
        return new Result("添加失败！", Constants.Code.ERROR_CODE, count, null);
    }

    @RequestMapping(path = "/listbook", method = RequestMethod.POST)
    @ResponseBody
    public Result listBook (int page, int size, Book book) {
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
}
