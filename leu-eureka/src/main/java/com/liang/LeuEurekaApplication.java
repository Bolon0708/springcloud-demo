package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启用eureka服务端
public class LeuEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeuEurekaApplication.class, args);
    }

}
