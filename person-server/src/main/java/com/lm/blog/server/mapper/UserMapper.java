package com.lm.blog.server.mapper;
import java.util.Collection;

import com.lm.blog.server.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Administrator
 * @Description 用户mapper层
 * @Date 2023/1/20
 */
@Mapper
public interface UserMapper {

     /**
      * 根据邮箱等值查询
      * @param email 邮箱
      * @return 用户信息
      */
     UserDO getByEmail(@Param("email") String email);

     /**
      * 返回所有用户信息
      */
     List<UserDO> listAll();

     UserDO getByMobile(@Param("mobile") String mobile);

     /**
      * 根据邮箱全模糊查询
      * @param email 邮箱
      * @return 用户集合
      */
     List<UserDO> listByEmailLike(@Param("email") String email);

     /**
      *  选择性插入
      */
     int insertSelective(UserDO userDO);

     /**
      *  批量插入
      */
     int insertBatch(@Param("userDOCollection") List<UserDO> userDOCollection);
}
