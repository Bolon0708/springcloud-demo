package com.liang.com.leu.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @ClassName: User
 * @Author: Bolon
 * @Date: 2019/11/23 12:19
 * @Description: TODO
 */
@Data
public class User {
    @Id
    private Long id;
    private String userName;
    private String address;
}
