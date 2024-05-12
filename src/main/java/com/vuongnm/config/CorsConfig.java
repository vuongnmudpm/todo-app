package com.vuongnm.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080"); // Thay đổi origin theo máy chủ Vue.js của bạn
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        return config;
    }
}
