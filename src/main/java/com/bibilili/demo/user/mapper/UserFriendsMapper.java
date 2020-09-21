package com.bibilili.demo.user.mapper;

import com.bibilili.demo.user.entity.User;
import com.bibilili.demo.user.vo.UserFriendsVO;

import java.util.List;

/**
 * @program: bibilili
 * @description: 用户关系mapper
 * @author: han.zhang
 * @create: 2020/09/10 11:49
 */
public interface UserFriendsMapper {
    /**
     * @Description 根据用户Id查询其好友
     * @param user
     * @return java.util.List<com.bibilili.demo.user.entity.UserFriends>
     * @Date 2020-09-11 11:22
     * @Author han.zhang
     */
    List<UserFriendsVO> selectFriends(User user);
}