package com.liang.com.leu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: LeuApplication
 * @Author: Bolon
 * @Date: 2019/11/23 12:19
 * @Description: TODO
 */
@SpringBootApplication
@MapperScan("com.liang.com.leu.mapper")
@EnableDiscoveryClient
public class LeuApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeuApplication.class, args);
    }

}
