package com.iebook;

import com.iebook.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = UserDao.class)
public class IEBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(IEBookApplication.class, args);
    }
}
