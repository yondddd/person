package com.lm.blog.server.learn.base.knows;

/**
 * @author yond
 * @date 2023/7/23
 * @description 接口
 */
public interface InterfaceService {

    void say();

    default String sayWhat() {
        return "haha";
    }

    int a = 1;

}
