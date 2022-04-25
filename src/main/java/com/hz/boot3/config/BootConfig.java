package com.hz.boot3.config;

import com.hz.boot3.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfig {

    /*@Value("${uname}")*/
    public String uname;


//    @Bean
//    public User newUser(){
//        User user = new User();
//
//        user.setUserName(uname);
//        return user;
//    }

}
