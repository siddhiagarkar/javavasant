package com.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Vehicle obj1 = (Vehicle) context.getBean("car");
        obj1.drive();
//
//        Tyre t = (Tyre) context.getBean("tyre");
//        System.out.println(t);
    }
}
