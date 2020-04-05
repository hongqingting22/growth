package com.lxl.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("HELLO-SERVICE")
public interface HelloServiceInterface {
    @RequestMapping("/hello/hello")
    String hello(@RequestParam("name") String name);
}
