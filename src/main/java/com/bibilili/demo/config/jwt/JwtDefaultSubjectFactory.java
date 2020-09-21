package com.bibilili.demo.config.jwt;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * @program: bibilili
 * @description: 关闭Shiro的Session功能
 * @author: han.zhang
 * @create: 2020/09/09 14:56
 */
public class JwtDefaultSubjectFactory extends DefaultWebSubjectFactory {
    @Override
    public Subject createSubject(SubjectContext context) {
        // 不创建 session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}