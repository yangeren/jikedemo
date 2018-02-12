package cn.wanghan.demo.controller;

import cn.wanghan.demo.form.ProductForm;
import cn.wanghan.demo.model.Product;
import cn.wanghan.demo.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class ProductControllerZ {
    private static final Log logger = LogFactory.getLog(ProductControllerZ.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/input-product")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }

    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(
//            ProductForm productForm,
            // 数据绑定
            Product product,
            RedirectAttributes redirectAttributes) {
        logger.info("saveProduct called");

        // no need to create and instantiate a ProductForm
        // create Product

        // 使用数据绑定，则不用以下工作
//        Product product = new Product();
//        product.setName(productForm.getName());
//        product.setDescription(productForm.getDescription());
//        try {
//            product.setPrice(new BigDecimal(productForm.getPrice()));
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            logger.error(e);
//        }

        // add product
        Product savedProduct = productService.add(product);

        // use flash method
        redirectAttributes.addFlashAttribute("message",
                "The product was successfully added.");
        return "redirect:/product-view/" + savedProduct.getId();
    }

    @RequestMapping(value = "/product-view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductView";
    }

}

