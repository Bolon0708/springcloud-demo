package com.liang.com.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: User
 * @Author: Bolon
 * @Date: 2019/11/23 12:19
 * @Description: TODO
 */
@Data
@Builder    //@Builder声明实体，表示可以进行Builder方式初始化
public class User {
    private Long id;
    private String userName;
    private String address;
}
