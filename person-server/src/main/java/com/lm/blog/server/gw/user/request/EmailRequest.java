package com.lm.blog.server.gw.user.request;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Description 邮箱请求
 * @Date 2023/1/20
 */
public class EmailRequest implements Serializable {

    private static final long serialVersionUID = -7334333425521729147L;

    /**
     * 邮箱
     */
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
