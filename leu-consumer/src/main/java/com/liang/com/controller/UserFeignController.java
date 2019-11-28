package com.liang.com.controller;

import com.liang.com.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Author: Bolon
 * @Date: 2019/11/23 13:36
 * @Description: TODO
 */
@RestController
@RequestMapping("feign")
public class UserFeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping
    public String queryUserById(@RequestParam("id") Long id) {
        return userClient.getUserById(id).toString();
    }
}
