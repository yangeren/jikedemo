package com.example.jikedemo.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class HelloTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        Hello hello = new Hello();
        mockMvc = MockMvcBuilders.standaloneSetup(hello).build();
    }


    @Test
    public void world() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(result.getResponse());
        System.out.println(result.toString());

    }

}