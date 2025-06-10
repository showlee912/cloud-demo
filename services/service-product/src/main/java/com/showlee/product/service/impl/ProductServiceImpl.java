package com.showlee.product.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.showlee.model.product.bean.Product;
import com.showlee.product.service.ProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("5"));
        product.setProductName("热干面");
        product.setNum(10);

//        try {
//            TimeUnit.SECONDS.sleep(30);//休眠，超时测试
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


        return product;
    }
}
