package com.adobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class App extends SpringBootServletInitializer
{

    @GetMapping("/timed")
    public String sayTimed() throws InterruptedException
    {
        Thread.sleep((long)(Math.random()*5000)); //it will randomly take max 5 seconds
        return "Hello, working";
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
