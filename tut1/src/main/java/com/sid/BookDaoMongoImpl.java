package com.sid;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BookDaoMongoImpl implements BookDao{
    public void addBook()
    {
        System.out.println("Mongo added");
    }
}
