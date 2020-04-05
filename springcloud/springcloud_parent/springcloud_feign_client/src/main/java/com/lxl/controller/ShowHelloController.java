package com.lxl.controller;

import com.lxl.interfaces.HelloServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowHelloController {

    @Autowired
    HelloServiceInterface helloServiceInterface;

    @RequestMapping("/hello")
    public String hello(String name){
        return helloServiceInterface.hello(name);
    }
}
