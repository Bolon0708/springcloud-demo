package com.liang.com.leu.service;

import com.liang.com.leu.mapper.UserMapper;
import com.liang.com.leu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: UserService
 * @Author: Bolon
 * @Date: 2019/11/23 12:30
 * @Description: TODO
 */
@Service
public class UserService {
    @Resource
    public UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
