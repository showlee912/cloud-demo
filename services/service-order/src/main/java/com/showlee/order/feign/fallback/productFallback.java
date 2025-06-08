package com.showlee.order.feign.fallback;

import com.showlee.model.product.bean.Product;
import com.showlee.order.feign.ProductFeignClient;
import org.springframework.stereotype.Component;


//当出现错误时，商品的兜底数据
@Component
public class productFallback implements ProductFeignClient {
    /**
     * @param productId
     * @return
     */
    @Override
    public Product getProduct(Long productId) {
        return new Product() {
            {
                setId(productId);
                setPrice(new java.math.BigDecimal("0.00"));
                setProductName("商品已下架");
                setNum(0);
            }
        };
    }
}
