package com.lm.blog.server.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * 封装常用业务异常
 * @author wangjielong
 * @date 2022/8/11 15:34
 */
public class BusinessExceptionUtil {

    public static void notNull(Object o, String message) {
        if (o == null) {
            throw new BusinessException(message);
        }
    }

    public static void notBlank(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new BusinessException(message);
        }
    }

    public static void mustBlank(String string, String message) {
        if (StringUtils.isNotBlank(string)) {
            throw new BusinessException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(message);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new BusinessException(message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }

    public static void checkPageParam(Integer pageNo, Integer pageSize, String message) {
        if (null == pageNo || null == pageSize || pageNo < 1 || pageSize < 1) {
            throw new BusinessException(message);
        }
    }
}
