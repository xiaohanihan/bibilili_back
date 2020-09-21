package com.bibilili.demo.user.controllers;

import com.bibilili.demo.user.entity.User;
import com.bibilili.demo.user.mapper.UserMapper;
import com.bibilili.demo.util.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: bibilili
 * @description:
 * @author: han.zhang
 * @create: 2020/09/03 20:46
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin(value = "*")
public class UserController {
    @Autowired(required = true)
    public UserMapper userMapper;

    @GetMapping
    public ResponseMsg getUsers(User user){
        ResponseMsg responseMsg = new ResponseMsg();
        try {
            List<User> users = userMapper.selectUsers(user);
            responseMsg.setObjectList(users);
            if(CollectionUtils.isEmpty(users)){
                responseMsg.setSuccess(false);
                responseMsg.setMessage("未查询到用户");
            }else {
                responseMsg.setMessage("查询成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseMsg.setMessage(e.getMessage());
            responseMsg.setSuccess(false);
        }
        return responseMsg;
    }

    @PostMapping
    public ResponseMsg saveUser(@RequestBody  User user){
        ResponseMsg responseMsg = new ResponseMsg();
        try {
            userMapper.insertUser(user);
            responseMsg.setMessage("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            responseMsg.setMessage(e.getMessage());
            responseMsg.setSuccess(false);
        }

        return responseMsg;
    }
}