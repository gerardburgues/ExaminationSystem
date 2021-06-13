package com.SSD.SSD;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigure implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homeScreen");
        //registry.addViewController("/home").setViewName("homeScreen");
        registry.addViewController("/student/loginoficial").setViewName("student/loginoficial");
        registry.addViewController("/professor/LoginProfessor").setViewName("professor/LoginProfessor");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("professor/profile/{}").setViewName("profile");


    }

}