package com.showlee.order.controller;


import com.showlee.model.order.bean.Order;
import com.showlee.order.feign.ApifoxFeignClient;
import com.showlee.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ApifoxFeignClient apifoxFeignClient;

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){
        Order order = orderService.createOrder(productId, userId);
        return order;
    }

    //测试第三方Apifox的调用
    @GetMapping("/getApifox")
    public Object testApifox(@RequestParam("nickname") String nickname,@RequestParam("age") String age){
        return apifoxFeignClient.getResponse(nickname,age);
    }
}
