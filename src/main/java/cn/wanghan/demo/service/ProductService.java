package cn.wanghan.demo.service;

import cn.wanghan.demo.model.Product;

public interface ProductService {
    Product add(Product product);
    Product get(Long id);
}
