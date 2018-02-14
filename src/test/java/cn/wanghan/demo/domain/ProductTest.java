package cn.wanghan.demo.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import seven.spring.mvc.Product;

public class ProductTest {

    Product product;
    private static final Log logging = LogFactory.getLog(ProductTest.class);

    @Before
    public void setUp(){
        product = new Product();
        logging.info("before test");
    }
    @Test
    public void getName() throws Exception {
        System.out.println(product.getName());
    }


    @Test
    public void setName() throws Exception {
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void setDescription() throws Exception {
    }

    @Test
    public void getPrice() throws Exception {
    }

    @Test
    public void setPrice() throws Exception {
    }

    @Test
    public void getPriductionDate() throws Exception {
    }

    @Test
    public void setPriductionDate() throws Exception {
    }

}