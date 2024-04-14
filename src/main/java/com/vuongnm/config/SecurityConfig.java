package com.vuongnm.config;


import com.vuongnm.model.User;
import com.vuongnm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1").password(pe.encode("123")).roles("GUEST")
                .and()
                .withUser("user2").password(pe.encode("123")).roles("USER", "GUEST")
                .and()
                .withUser("user3").password(pe.encode("123")).roles("USER", "GUEST", "ADMIN");

        auth.userDetailsService(username -> {
            try {
                User user = userService.getUserByUsername(username).getBody().getData();
                    String password = pe.encode(user.getPassword());
                    return org.springframework.security.core.userdetails.User.withUsername(username).password(password).roles("GUEST").build();
            } catch (NoSuchElementException nsee) {
                throw new UsernameNotFoundException(username + "not found");
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();
        http.authorizeRequests()
                .antMatchers("/security/**").hasRole("USER")
                .anyRequest().permitAll();

        http.exceptionHandling().accessDeniedPage("/auth/denied");
        http.httpBasic();
    }
}