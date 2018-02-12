package com.example.jikedemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
//@RequestMapping("/hello")
public class Hello {

    private static final Log logging = LogFactory.getLog(Hello.class);

    @RequestMapping("/rest")
    public String rest(@RequestParam("id") String ids) {
        return ids;
    }

    @RequestMapping("/something")
    public ResponseEntity<String> handle (HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        logging.info(requestEntity.toString());
        logging.info(requestBody);
        //do something with request header and body

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }

    public Hello() {

    }
}