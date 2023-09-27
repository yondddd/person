package com.lm.blog.server.gw.user.controller;


import com.alibaba.fastjson2.JSON;
import com.lm.blog.common.response.RemoteResponse;
import com.lm.blog.server.BlogServerApplication;
import com.lm.blog.server.gw.user.request.EmailRequest;
import com.lm.blog.server.gw.user.request.MobileRequest;
import com.lm.blog.server.gw.user.response.UserVO;
import com.lm.blog.server.model.UserDO;
import com.lm.blog.server.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Description 用户
 * @Date 2023/1/20
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/listAll")
    @ResponseBody
    public RemoteResponse<List<UserVO>> list() {
        UserDO userDO = new UserDO();
        List<UserDO> allUsers = userService.listAll();
        System.out.println(JSON.toJSON(allUsers));
        // 若为空,直接返回空集合
        if (CollectionUtils.isEmpty(allUsers)) {
            return RemoteResponse.<List<UserVO>>custom().setData(Collections.emptyList()).setSuccess();
        }
        List<UserVO> collect = allUsers.stream().map(this::do2vo).collect(Collectors.toList());
        return RemoteResponse.<List<UserVO>>custom().setData(collect).setSuccess();
    }


    @RequestMapping("/getByEmail")
    @ResponseBody
    public RemoteResponse<List<UserVO>> getByEmail(@RequestBody EmailRequest request) {
        if (request == null || StringUtils.isBlank(request.getEmail())) {
            return RemoteResponse.<List<UserVO>>custom().setFailure("请求参数错误");
        }
        List<UserDO> userByEmail = userService.listByEmailLike(request.getEmail());
        List<UserVO> result = new ArrayList<>();
        for (UserDO userDO : userByEmail) {
            result.add(this.do2vo(userDO));;
        }
        return RemoteResponse.<List<UserVO>>custom().setData(result).setSuccess();
    }

    /**
     * 1.先完成上面接口的单元测试与postman测试,启动类为{@link BlogServerApplication}
     * 2.然后仿照上面格式写一个根据手机号查询用户信息的接口,用户名字为小红,完成单元测试与postman接口调用
     * 3.目标：
     * 完成单元测试
     * 添加postman请求 在blog/user 文件夹下添加一个查询此接口的请求
     */
    @RequestMapping("/getByMobile")
    @ResponseBody
    public RemoteResponse<UserVO> getByMobile(@RequestBody MobileRequest request) {
        UserDO userByMobile = userService.getByMobile(request.getMobile());
        UserVO result = new UserVO();
        userService.getByMobile(request.getMobile());
        result.setUserId(userByMobile.getId());
        result.setEmail(userByMobile.getEmail());
        result.setMobile(userByMobile.getMobile());
        result.setUserName(userByMobile.getName());
        return RemoteResponse.<UserVO>custom().setData(result).setSuccess();
    }

    /**
     * do转vo
     * @param from 数据库do对象
     * @return to 前端展示对象
     */
    private UserVO do2vo(UserDO from) {
        if (from == null) {
            return null;
        }
        UserVO to = new UserVO();
        to.setUserId(from.getId());
        to.setUserName(from.getName());
        to.setEmail(from.getEmail());
        to.setMobile(from.getMobile());
        return to;
    }

}
