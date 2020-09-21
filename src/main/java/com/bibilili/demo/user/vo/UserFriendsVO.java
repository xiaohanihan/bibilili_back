package com.bibilili.demo.user.vo;

import com.bibilili.demo.user.entity.User;
import com.bibilili.demo.user.entity.UserFriends;
import lombok.Data;

/**
 * @program: bibilili
 * @description: 用户朋友VO
 * @author: han.zhang
 * @create: 2020/09/11 11:48
 */
@Data
public class UserFriendsVO extends UserFriends {
    // 好友的信息
    private String name;

    /**
     * 登录名
     */
    private String loginName;
    /**
     * 头像路径
     */
    private String headUrl;
}