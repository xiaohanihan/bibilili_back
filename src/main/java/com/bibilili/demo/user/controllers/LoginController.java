package com.bibilili.demo.user.controllers;

import com.bibilili.demo.config.jwt.JwtUtil;
import com.bibilili.demo.user.entity.User;
import com.bibilili.demo.user.mapper.UserMapper;
import com.bibilili.demo.util.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bibilili
 * @description: 登录
 * @author: han.zhang
 * @create: 2020/09/09 16:13
 */
@RestController
public class LoginController {
    @Autowired(required = true)
    public UserMapper userMapper;

    /**
     * @Description 登录
     * @param user
     * @return com.bibilili.demo.util.ResponseMsg
     * @Date 2020-09-09 16:18
     * @Author han.zhang
     */
    @GetMapping("/login")
    public ResponseMsg login(User user){
        // 验证用户名和密码参数
        if(StringUtils.isEmpty(user.getLoginName()) || StringUtils.isEmpty(user.getPwd())){
            return new ResponseMsg(false,"请输入用户名和密码");
        }
        // 校验用户名是否存在
        User verifyUser = new User();
        verifyUser.setLoginName(user.getLoginName());
        List<User> users = userMapper.selectUsers(verifyUser);
        if(CollectionUtils.isEmpty(users)){
            return new ResponseMsg(false,"用户名不存在");
        }
        // 校验用户名和密码是否正确
        verifyUser.setPwd(user.getPwd());
        List<User> users2 = userMapper.selectUsers(verifyUser);
        if(CollectionUtils.isEmpty(users2)){
            return new ResponseMsg(false,"用户名或密码不正确");
        }
        verifyUser = users2.get(0);
        // 生成token并返回到前台
        JwtUtil jwtUtil = new JwtUtil();
        Map<String,Object> map = new HashMap<>(3);
        map.put("loginName",verifyUser.getLoginName());
        String jwtToken = jwtUtil.encode(verifyUser.getLoginName(), 24 * 60 * 60 * 1000, map);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("token",jwtToken);
        resultMap.put("user",verifyUser);
        return new ResponseMsg(true,"登录成功",resultMap);
    }

    /**
     * @Description 登出
     * @param user
     * @return com.bibilili.demo.util.ResponseMsg
     * @Date 2020-09-09 16:45
     * @Author han.zhang
     */
//    public ResponseMsg logOut(User user){
//
//    }
}