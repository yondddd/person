package com.lm.blog.server.service;

import com.lm.blog.server.model.UserDO;

import java.util.List;

/**
 * @Author Administrator
 * @Description 用户service接口
 * @Date 2023/1/20
 */
public interface UserService {

    /**
     * 根据邮箱查找用户信息
     * @param email 邮箱
     * @return 用户信息
     */
    UserDO getByEmail(String email);

    /**
     * 根据手机号查找用户信息
     * @param mobile 手机号
     * @return 用户信息
     */
    UserDO getByMobile(String mobile);

    /**
     * 返回所有用户信息
     */
    List<UserDO> listAll();

    /**
     * 根据邮箱全模糊查询
     * @param email 邮箱
     * @return 用户集合
     */
    List<UserDO> listByEmailLike(String email);

    /**
     * 插入
     */
    void insert(UserDO user);

    /**
     * 批量插入
     */
    void batchInsert(List<UserDO> users);
}
