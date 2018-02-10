package com.example.jikedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class Hello {

    @ResponseBody
    @RequestMapping("/world")
    public String world() {
        System.out.println("hello world");
        return "world";
    }
}
