package com.sid;

import org.springframework.stereotype.Component;

@Component("snapdragon")
public class Snapdragon implements MobileProcessor{
    public void process(){
        System.out.println("World's best CPU");
    }
}
