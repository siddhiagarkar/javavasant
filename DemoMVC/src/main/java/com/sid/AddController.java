package com.sid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {

    @RequestMapping(value = "/metrics")
    public String metrics(){
        return "display.jsp";
    }
}

