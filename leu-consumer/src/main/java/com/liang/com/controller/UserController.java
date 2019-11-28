package com.liang.com.controller;

import com.liang.com.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: UserController
 * @Author: Bolon
 * @Date: 2019/11/23 13:36
 * @Description: TODO
 */
@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "fallbackMethod")//定义全局熔断方法
public class UserController {
    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public DiscoveryClient discoveryClient;

    @GetMapping
    @HystrixCommand //声明被熔断方法
    public String queryUserById(@RequestParam("id") Long id) {
        ServiceInstance serviceInstance = discoveryClient.getInstances("leu-provider").get(0);
        System.out.println(serviceInstance.getHost() +":"+ serviceInstance.getPort());
        return restTemplate.getForObject("http://leu-provider/user/" + id, User.class).toString();
    }

    public String fallbackMethod(){
        return  "服务正忙，请稍候再试！";
    }
}
