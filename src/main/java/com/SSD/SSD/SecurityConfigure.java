package com.SSD.SSD;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigure implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index/role");
        registry.addViewController("/home").setViewName("homeScreen");
        registry.addViewController("/loginoficial").setViewName("loginoficial");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index/professor").setViewName("indexProfessor");
        registry.addViewController("/profile").setViewName("professorProfile");
        registry.addViewController("/course").setViewName("course");
        registry.addViewController("/showTestForm").setViewName("showTestForm");
        registry.addViewController("/AddQuestionForm").setViewName("AddQuestionForm");
    }
}