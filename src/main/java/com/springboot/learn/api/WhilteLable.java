package com.springboot.learn.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WhilteLable {
    @RequestMapping(method = RequestMethod.GET)
    public String whileLabelMessage(){
        return "this is home page"+new Date();
    }
}
