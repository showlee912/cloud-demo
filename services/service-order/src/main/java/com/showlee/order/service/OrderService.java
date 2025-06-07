package com.showlee.order.service;
import com.showlee.model.order.bean.Order;
import com.showlee.model.product.bean.Product;


public interface OrderService {
    Order createOrder(Long productId, Long userId);

    Product getProductFromRemote(Long productId);
}
