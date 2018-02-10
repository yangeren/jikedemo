package com.example.jikedemo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.logging.Logger;

@Controller
@RequestMapping(method = RequestMethod.GET, path = "/page")
public class A {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(A.class);

    private B b;

    public void importantMethod() {
        b.usefulMethod();
    }

    public void setB(B b) {
        this.b = b;
    }

//    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(
            Model model
    ) {
//        logger.info("goodjob");
        model.addAttribute("message", "Hello Spring MVC");
        return "jike";
    }

    @RequestMapping(path = "/get")
//    @ResponseBody
    public String h() {
        return "name";
    }

    @RequestMapping("/index")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView("/jike");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(path = "/text", method = RequestMethod.GET)
    public String good() {
        return "this is the home page";
    }
//    ApplicationContext context = new ClassPathXmlApplicationContext(
//            new String[] {"spring-config.xml"}
//    );
//    LocalDate localDate = context.getBean("localDate", LocalDate.class);
}
