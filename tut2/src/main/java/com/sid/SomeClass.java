package com.sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SomeClass {

    @Autowired
    private BookDao obj1;

    public BookDao getObj1() {
        return obj1;
    }

    public void setObj1(BookDao obj1) {
        this.obj1 = obj1;
    }

//    @Bean
    public void final_func()
    {
        System.out.println("Called!!");
        obj1.addBook();
    }
}
