package com.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Spring Core Annotations
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Apple iphone12 = (Apple) factory.getBean(Apple.class);
        iphone12.config();
    }
}
