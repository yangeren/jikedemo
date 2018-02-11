package cn.wanghan.demo.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerServletTest {

    @Test
    public void h() {
        String uri = "/priceapi/getname";
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        System.out.println(lastIndex);
        System.out.println(action);
    }
}