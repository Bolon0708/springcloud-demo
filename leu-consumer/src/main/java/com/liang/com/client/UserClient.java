package com.liang.com.client;

import com.liang.com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: userClient
 * @Author: Bolon
 * @Date: 2019/11/25 20:28
 * @Description: TODO
 */
@FeignClient(value = "leu-provider", fallback = UserClientFallback.class) //声明为feign接口，value参数为服务id，fallback为熔断参数
public interface UserClient {

    /**
     * 功能描述: 根据id查询用户
     * @param: id
     * @return: User
     * @auther: Bolon
     * @date: 2019/11/25 20:47
     */
    @GetMapping("user/{id}")
    User getUserById(@PathVariable("id") Long id);
}
