package com.sid;
import org.springframework.stereotype.Component;

@Component
public class BookDaoMySQLImpl implements BookDao{
    public void addBook()
    {
        System.out.println("MySQL added");
    }
}
