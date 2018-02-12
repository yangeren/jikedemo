package com.example.jikedemo.controller;

import com.example.jikedemo.dao.Product;
import com.example.jikedemo.form.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

//@WebServlet(name = "ControllerServlet", urlPatterns = {
//        "/input-product", "/save-product"
//})
public class ControllerServlet  extends HttpServlet{

    private static final long serialVersionUID = 1579L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        process(request, response);
    }


    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        String dispatchUrl = null;

        if ("input-product".equals(action)) {
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else if ("save-product".equals(action)){
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(new BigDecimal(productForm.getPrice()));
            } catch (NumberFormatException e) {
                SaveProductAction saveProductAction =
                        new SaveProductAction();
                saveProductAction.save(product);

                request.setAttribute("product", product);
                dispatchUrl = "/jsp/ProductDetails.jsp";
            }

            if (dispatchUrl != null) {
                RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
                rd.forward(request, response);
            }
        }
    }
}
