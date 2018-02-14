package seven.spring.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ProductControllerS {
    private static final Log logging = LogFactory.getLog(ProductControllerS.class);

    @RequestMapping(value = "/seven-add-product")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/seven/ProductForm";
    }

    @RequestMapping(value = "/seven-save-product")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product, bindingResult);


        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logging.debug("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            return "/seven/ProductForm";
        }
        model.addAttribute("product", product);
        return "/seven/ProductDetails";
    }
}
