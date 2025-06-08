package com.showlee.order.feign;


import com.showlee.model.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 对微服务远程调用的http客户端*/
@FeignClient(name = "service-product")//指定要调用的服务名
public interface ProductFeignClient {

    //查询商品
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId);

}
