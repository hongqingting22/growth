package com.lxl;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/show")
public class ShowHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hello")
    @Hystrix(fallbackHandler = {})
    public String showHello(String name){
        /*String url = "http://localhost:8989/hello/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;*/

        //choose后面是应用名称  spring.application.name
        ServiceInstance choose = loadBalancerClient.choose("HELLO-SERVICE");
        String host = choose.getHost();
        int port = choose.getPort();
        System.out.println("host:" + host+",port:" + port);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + host + ":" + port + "/hello?name=" + name;
        return restTemplate.getForObject(url , String.class);
    }

}
