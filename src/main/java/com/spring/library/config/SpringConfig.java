package com.spring.library.config;

import com.spring.library.repositories.UserRepository;
import com.spring.library.service.UserDetailsServiceImpl;
import com.spring.library.service.UserService;
import com.spring.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig(UserRepository userRepository) {
    }

    @Bean
    @Qualifier("UserDetailsService")
    public UserDetailsService getuserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @Qualifier("UserService")
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
