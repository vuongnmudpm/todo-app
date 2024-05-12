package com.vuongnm.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/*").allowedOrigins("http://localhost:8080"); // Thay đổi endpoint nếu cần
        registry.addMapping("/task/*").allowedOrigins("http://localhost:8080"); // Thay đổi endpoint nếu cần
    }
}
