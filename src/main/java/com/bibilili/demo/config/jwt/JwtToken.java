package com.bibilili.demo.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @program: bibilili
 * @description: 封装需要传递的jwt字符串
 * @author: han.zhang
 * @create: 2020/09/09 15:07
 */
public class JwtToken implements AuthenticationToken {
    private String jwt;

    public JwtToken(String jwt) {
        this.jwt = jwt;
    }

    @Override//类似是用户名
    public Object getPrincipal() {
        return jwt;
    }

    @Override//类似密码
    public Object getCredentials() {
        return jwt;
    }
    //返回的都是jwt
}