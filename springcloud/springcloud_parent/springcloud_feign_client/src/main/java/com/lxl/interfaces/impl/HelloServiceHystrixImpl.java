package com.lxl.interfaces.impl;

import com.lxl.interfaces.HelloServiceInterface;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrixImpl implements HelloServiceInterface {
    @Override
    public String hello(String name) {
        return "server is down";
    }
}
