package com.showlee.order.service;
import com.showlee.order.bean.Order;
import com.showlee.product.bean.Product;


public interface OrderService {
    Order createOrder(Long productId, Long userId);

    Product getProductFromRemote(Long productId);
}
