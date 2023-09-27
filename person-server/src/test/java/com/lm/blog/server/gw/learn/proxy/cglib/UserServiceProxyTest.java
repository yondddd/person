package com.lm.blog.server.gw.learn.proxy.cglib;

import com.lm.blog.server.BaseTest;
import com.lm.blog.server.learn.proxy.UserServiceObjectImpl;
import com.lm.blog.server.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;

import javax.annotation.Resource;

/**
 * @author yond
 * @date 2023/5/16 21:59
 * @description
 */
public class UserServiceProxyTest extends BaseTest {

    // 注入的方式无法成功代理
    @Resource
    private UserServiceObjectImpl proxy = (UserServiceObjectImpl) new com.lm.blog.server.learn.proxy.cglib.UserServiceProxy().getUserLogProxy(new UserServiceObjectImpl());

    @Test
    public void listAllProxy() {
         UserServiceObjectImpl proxy = (UserServiceObjectImpl) new com.lm.blog.server.learn.proxy.cglib.UserServiceProxy().getUserLogProxy(new UserServiceObjectImpl());
        System.out.println(proxy.findUserList());
    }


}
