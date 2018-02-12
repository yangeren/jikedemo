package cn.wanghan.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/customer")
public class CustomerController {

    private static final Log logger = LogFactory.getLog(CustomerController.class);

    @RequestMapping(value = "/input-customer")
    public String inputCustomer() {
        // do something here

        return "CustomerForm";
    }

    @RequestMapping(value = "/process-order",method = {RequestMethod.POST, RequestMethod.PUT})
    public String processOrder() {
        // do something here

        return "OrderForm";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.PUT})
    public String deleteCustomer() {
        // do something here

        return "deleteForm";
    }

    @RequestMapping("/uri")
    public String myMethod(HttpSession session) {

        logger.info(session.toString());
//        session.addAttrobute
        return "";
    }
}
