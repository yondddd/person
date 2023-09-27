package com.lm.blog.server.gw.user.request;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Description 手机号请求
 * @Date 2023/1/20
 */
public class MobileRequest implements Serializable {

    private static final long serialVersionUID = -1004916865260532475L;
    /**
     * 手机号
     */
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MobileRequest{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
