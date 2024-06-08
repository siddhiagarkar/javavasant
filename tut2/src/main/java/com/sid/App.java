package com.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World" );

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SomeClass obj = (SomeClass) context.getBean(SomeClass.class);
        obj.final_func();
    }
}
