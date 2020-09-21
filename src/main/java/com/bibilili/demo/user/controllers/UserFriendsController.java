package com.bibilili.demo.user.controllers;

import com.bibilili.demo.user.entity.User;
import com.bibilili.demo.user.entity.UserFriends;
import com.bibilili.demo.user.mapper.UserFriendsMapper;
import com.bibilili.demo.user.mapper.UserMapper;
import com.bibilili.demo.user.vo.UserFriendsVO;
import com.bibilili.demo.util.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bibilili
 * @description: 查询好友关系
 * @author: han.zhang
 * @create: 2020/09/10 11:54
 */
@RestController
@RequestMapping("/user-friends")
public class UserFriendsController {
    @Autowired
    private UserFriendsMapper userFriendsMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseMsg getUserFriends(User user){
        // 校验参数
        if(StringUtils.isEmpty(user.getUserId())){
            return new ResponseMsg(false,"缺少用户id参数");
        }
        // 查询好友
        List<UserFriendsVO> userFriends = userFriendsMapper.selectFriends(user);
        return new ResponseMsg(false,"成功",userFriends);
    }
}