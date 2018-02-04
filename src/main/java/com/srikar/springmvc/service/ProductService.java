package com.srikar.springmvc.service;

import com.srikar.springmvc.domain.Product;


/**
 * Created by vedantas on 2/4/2018.
 */
public interface ProductService {
    void saveProduct(Product product);
    Product getProduct(Long id);
}
