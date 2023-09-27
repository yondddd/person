package com.lm.blog.server;

import com.alibaba.fastjson2.JSON;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yond
 * @date 2023/4/22 10:09
 * @description 基本测试类
 */
@SpringBootTest
public class BaseTest {

    public void print(Object o) {
        System.out.println(JSON.toJSON(o));
    }
}
