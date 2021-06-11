package com.SSD.SSD;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigure implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homeScreen");
        registry.addViewController("/home").setViewName("homeScreen");
        registry.addViewController("/loginoficial").setViewName("loginoficial");
        registry.addViewController("/hello").setViewName("hello");

    }

}