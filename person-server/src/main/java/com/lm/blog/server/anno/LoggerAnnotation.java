package com.lm.blog.server.anno;

import java.lang.annotation.*;

/**
 * @Author WangJieLong
 * @create 2022/8/11 10:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LoggerAnnotation {
}
