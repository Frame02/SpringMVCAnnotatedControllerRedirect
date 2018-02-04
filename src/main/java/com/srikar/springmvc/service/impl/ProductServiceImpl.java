package com.srikar.springmvc.service.impl;

import com.srikar.springmvc.domain.Product;
import com.srikar.springmvc.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vedantas on 2/4/2018.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private AtomicLong idGenerator = new AtomicLong();
    private Map<Long, Product> productMap = new HashMap<>();

    @Override
    public void saveProduct(Product product) {
        Long id = idGenerator.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    @Override
    public Product getProduct(Long id) {
        return productMap.get(id);
    }
}
