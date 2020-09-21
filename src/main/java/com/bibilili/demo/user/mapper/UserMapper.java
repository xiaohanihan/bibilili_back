package com.bibilili.demo.user.mapper;

import com.bibilili.demo.user.entity.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @program: bibilili
 * @description:
 * @author: han.zhang
 * @create: 2020/09/03 20:39
 */
public interface UserMapper {
    /**
     * @Description 查询
     * @param
     * @return java.util.List<com.bibilili.demo.user.entity.User>
     * @Date 2020-09-04 09:43
     * @Author han.zhang
     */
    List<User> selectUsers(User user);

    /**
     * @Description 插入
     * @param
     * @return
     * @Date 2020-09-04 09:43
     * @Author han.zhang
     */
    void insertUser(User user);
}