package com.lm.blog.server.gw.user.response;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Description 用户信息返回vo
 * @Date 2023/1/20
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = 5588776393819917198L;

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String mobile;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
