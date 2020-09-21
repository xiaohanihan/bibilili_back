package com.bibilili.demo.user.entity;

import lombok.Data;

/**
 * @program: bibilili
 * @description: 用户
 * @author: han.zhang
 * @create: 2020/09/03 20:28
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Long userId;


    private String name;
    private String loginName;
    private String pwd;
    private String headUrl;
}