package com.liang.com.client;

import com.liang.com.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserClientFallback
 * @Author: Bolon
 * @Date: 2019/11/25 20:54
 * @Description: TODO
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User getUserById(Long id) {
        return User.builder().address("杭州").userName("服务正忙，请稍后再试！！").build();
    }
}
