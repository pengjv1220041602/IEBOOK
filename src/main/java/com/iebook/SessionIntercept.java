package com.iebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author ZhPJ
 * @Date 2018/10/23 002311:16
 * @Version 1.0
 * @Description:
 */
@Configuration
public class SessionIntercept extends WebMvcConfigurerAdapter {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/main/**");//配置登录拦截器拦截路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/");//配置登录拦截器拦截路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/books/**");//配置登录拦截器拦截路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/kinds/**");//配置登录拦截器拦截路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/users/**");//配置登录拦截器拦截路径
    }
}
