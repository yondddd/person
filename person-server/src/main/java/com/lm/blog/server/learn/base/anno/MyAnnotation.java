package com.lm.blog.server.learn.base.anno;

import java.lang.annotation.*;

/**
 * @author yond
 * @date 2023/8/12
 * @description 我的注解
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
}
