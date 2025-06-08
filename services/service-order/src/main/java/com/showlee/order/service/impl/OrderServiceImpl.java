package com.showlee.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;


import com.showlee.model.order.bean.Order;
import com.showlee.model.product.bean.Product;
import com.showlee.order.feign.ProductFeignClient;
import com.showlee.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductFeignClient productFeignClient;

    /**
     * 创建订单
     * @param productId 商品id
     * @param userId 用户id
     * @return 订单对象
     */
    @Override
    public Order createOrder(Long productId, Long userId) {
        //根据productId远程调用商品服务，获取商品信息
//        Product product = getProductFromRemoteByIdWithLB(productId);
        Product product = productFeignClient.getProduct(productId);//使用Openfeign进行远程调用
        Order order = new Order();
        order.setId(new Random().nextLong(1000));
        order.setUserId(userId);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setNickName("jack");
        order.setAddress("流芳");
        order.setProductList(List.of(product));

        return order;
    }


    /**
     * 远程调用商品服务获取商品信息
     * @param productId 商品id
     * @return 商品对象
     */
    public Product getProductFromRemote(Long productId) {
        //获取到商品服务所在的服务器地址
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);
        //远程url
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + productId;
        System.out.println("远程调用的url:" + url);
        //发送http请求
        return restTemplate.getForObject(url, Product.class);
    }


    // 基于注解的负载均衡实现获取商品信息
    private Product getProductFromRemoteByIdWithLB(Long productId){
        //service-product 会被动态替换
        String url = "http://service-product/product/"+productId;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
