package com.lm.blog.server.utils;

/**
 * @author wangjielong
 * @date 2022/8/11 15:34
 * 统一业务异常（可展示给前端或其他调用方）
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -4708280662540248839L;

    public BusinessException(String message) {
        super(message);
    }
}
