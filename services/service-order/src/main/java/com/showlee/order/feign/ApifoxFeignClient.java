package com.showlee.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apifox-feign-client", url = "https://echo.apifox.com")
public interface ApifoxFeignClient {

    @GetMapping("/get")
    Object getResponse(@RequestParam("nickname") String nickname, @RequestParam("age") String age);

}
