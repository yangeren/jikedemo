package cn.wanghan.demo.controller;

import cn.wanghan.demo.form.ProductForm;
import cn.wanghan.demo.model.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class ProductController {

    private static final Log logging = LogFactory.getLog(ProductController.class);

//    @RequestMapping(value = "/input-product/")
    public String inputProduct() {
        logging.info("inputProduct called");
        return "ProductForm";
    }

//    @RequestMapping(value = "/save-product")
    public String saveProduct(ProductForm productForm, Model model) {
        logging.info("saveProduct called");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(new BigDecimal(productForm.getPrice()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logging.error(e);
        }
        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
