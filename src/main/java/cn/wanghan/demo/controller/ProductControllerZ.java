package cn.wanghan.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductControllerZ {
    private static final Log logger = LogFactory.getLog(ProductControllerZ.class);

    @RequestMapping(value = "/input-product")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }
}
