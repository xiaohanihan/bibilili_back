package com.bibilili.demo.user.entity;

import lombok.Data;

/**
 * @program: bibilili
 * @description: 用户关系
 * @author: han.zhang
 * @create: 2020/09/10 11:45
 */
@Data
public class UserFriends {
    /**
     * 主键，关系id
     */
    private Long shipId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 朋友Id
     */
    private Long friendId;
}