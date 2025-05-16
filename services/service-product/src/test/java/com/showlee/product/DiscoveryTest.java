package com.showlee.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * 服务发现测试*/
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    void testDiscoveryClient() {

        for (String service : discoveryClient.getServices()) {
            System.out.println("service = " + service);

            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("instance = " + instance.getServiceId() + " " + instance.getHost() + ":" + instance.getPort());
            }
        }
    }
}
