package com.sid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookDao func1(){
        return new BookDaoMongoImpl();
    }

    @Bean
    public BookDao func2(){
        return new BookDaoMySQLImpl();
    }

}
