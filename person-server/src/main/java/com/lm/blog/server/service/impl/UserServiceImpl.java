package com.lm.blog.server.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.lm.blog.server.mapper.UserMapper;
import com.lm.blog.server.model.UserDO;
import com.lm.blog.server.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Description 用户service接口实现
 * @Date 2023/1/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 全部用户缓存
     */
    private final Cache<String, List<UserDO>> ALL_USER_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.HOURS)
            .maximumSize(1)
            .build();

    private static final String KEY = "ALL_USER";

    @Override
    public UserDO getByEmail(String email) {
        // 参数异常校验,防止查询数据库异常
        Preconditions.checkArgument(StringUtils.isNotBlank(email),"邮箱不能为空");
        // userMapper层查询数据库
        return userMapper.getByEmail(email);
    }

    @Override
    public UserDO getByMobile(String mobile) {
        Preconditions.checkArgument(StringUtils.isNotBlank(mobile),"手机不能为空");
        return userMapper.getByMobile(mobile);
    }

    @Override
    public List<UserDO> listAll() {
        List<UserDO> result = ALL_USER_CACHE.getIfPresent(KEY);
        if (result == null) {
            result = userMapper.listAll();
            ALL_USER_CACHE.put(KEY, result);
            return result;
        }
        return result;
    }

    @Override
    public List<UserDO> listByEmailLike(String email) {
        if (StringUtils.isBlank(email)) {
            return Collections.emptyList();
        }
        return userMapper.listByEmailLike(email);
    }

    @Override
    public void insert(UserDO user) {
        Assert.notNull(user, "用户为空");
        userMapper.insertSelective(user);
    }

    @Override
    public void batchInsert(List<UserDO> users) {
        if (CollectionUtils.isEmpty(users)) {
            return;
        }
        userMapper.insertBatch(users);
    }

}
