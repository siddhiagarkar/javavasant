package com.sid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
public class BookDaoMySQLImpl implements BookDao{

//    @Bean
    public void addBook()
    {
        System.out.println("MySQL added");
    }
}
