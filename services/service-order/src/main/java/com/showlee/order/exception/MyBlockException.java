package com.showlee.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showlee.model.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * 自定义的Sentinel调用web接口的限流异常处理类
 *
 * */
@Component
public class MyBlockException implements BlockExceptionHandler {
    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param s
     * @param e
     * @throws Exception
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(429); // 设置HTTP状态码为429 Too Many Requests
        PrintWriter writer = httpServletResponse.getWriter();

        Result error = Result.error(429, "请求过于频繁，请稍后再试");

        ObjectMapper objectMapper = new ObjectMapper();

        String s1 = objectMapper.writeValueAsString(error);

        writer.write(s1);

        writer.flush();
        writer.close();

    }
}
