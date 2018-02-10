package com.example.jikedemo.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class ATest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        A a = new A();
        mockMvc = MockMvcBuilders.standaloneSetup(a).build();
    }

    @Test
    public void good() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/path/text"))
//                .andExpect(MockMvcResultMatchers.view().name("user"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(result.getResponse());
        System.out.println(result.getResponse().toString());
    }

}