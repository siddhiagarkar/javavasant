package com.sid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("apple") //default id is apple (non qualified and de capitalized)
public class Apple {

    @Autowired
    @Qualifier("snapdragon") //alt for @primary
    MobileProcessor cpu;
    //getter
    public MobileProcessor getCpu() {
        return cpu;
    }
    //setter
    public void setCpu(MobileProcessor cpu) {
        this.cpu = cpu;
    }

    public void config()
    {
        System.out.println("iOS 17.4.1, Hexa-core CPU, 4-core graphics GPU, 4GB RAM, 128GB Storage, 12MP camera");
        cpu.process();
    }
}
