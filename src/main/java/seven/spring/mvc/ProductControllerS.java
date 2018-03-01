package seven.spring.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductControllerS {
    private static final Log logging = LogFactory.getLog(ProductControllerS.class);

    @RequestMapping(value = "/seven-add-product")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/seven/ProductForm";
    }

    @RequestMapping(value = "/seven-save-product")
    public String saveProduct(
            HttpServletRequest servletRequest,
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult,
            Model model
    ) {
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                File imageFile = new File(
                        servletRequest.getServletContext().getRealPath("/image"),
                        fileName
                );
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("product", product);
        return "/seven/ProductDetails";

//        ProductValidator productValidator = new ProductValidator();
//        productValidator.validate(product, bindingResult);
//
//
//        if (bindingResult.hasErrors()) {
//            FieldError fieldError = bindingResult.getFieldError();
//            logging.debug("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
//            return "/seven/ProductForm";
//        }
//        model.addAttribute("product", product);
//        return "/seven/ProductDetails";
    }
}
