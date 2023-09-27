package com.lm.blog.server.gw.user;

import com.google.common.collect.Lists;
import com.lm.blog.common.response.RemoteResponse;
import com.lm.blog.server.BaseTest;
import com.lm.blog.server.gw.user.controller.UserController;
import com.lm.blog.server.gw.user.request.EmailRequest;
import com.lm.blog.server.gw.user.request.MobileRequest;
import com.lm.blog.server.gw.user.response.UserVO;
import com.lm.blog.server.model.UserDO;
import com.lm.blog.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Administrator
 * @Description 用户测试
 * @Date 2023/1/20
 */
@SpringBootTest
public class UserControllerTest extends BaseTest {

    @Resource
    private UserController userController;

    @Resource
    private UserService userService;

    @Test
    public void getByEmailTest() {
        EmailRequest request = new EmailRequest();
        request.setEmail("123456@qq.com");
        RemoteResponse<List<UserVO>> response = userController.getByEmail(request);
        System.out.println(response);
        request.setEmail("133223@qq.com");
        RemoteResponse<List<UserVO>> responseOne = userController.getByEmail(request);
        System.out.println(responseOne);
        request.setEmail("13888@qq.com");
        RemoteResponse<List<UserVO>> responseTwo = userController.getByEmail(request);
        System.out.println(responseTwo);
    }

    @Test
    public void getByMobileTest() {
        MobileRequest request = new MobileRequest();
        request.setMobile("手机");
        RemoteResponse<UserVO> response = userController.getByMobile(request);
        System.out.println(response);
    }

    @Test
    public void listAllTest() {
        // 用下动态代理给每个方法加耗时
        RemoteResponse<List<UserVO>> response = userController.list();
        print(response);
        for (UserVO data : response.getData()) {
            print(data);
        }
    }


    @Test
    public void insertTest() {
        List<UserDO> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            UserDO userDO = new UserDO();
            userDO.setName("名字" + i);
            userDO.setMobile("手机" + i);
            userDO.setEmail("邮箱" + i);
            userDO.setStatus(1);
            list.add(userDO);
        }
        long start = System.currentTimeMillis();
        for (UserDO userDO : list) {
            userService.insert(userDO);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void batchInsertTest() {
        List<UserDO> list = new ArrayList<>();
        for (int i = 100000; i < 10000000; i++) {
            UserDO userDO = new UserDO();
            userDO.setName("名字" + i);
            userDO.setMobile("手机" + i);
            userDO.setEmail("邮箱" + i);
            userDO.setStatus(1);
            list.add(userDO);
        }
        long start = System.currentTimeMillis();
        for (List<UserDO> userDOS : Lists.partition(list, 40000)) {
            userService.batchInsert(userDOS);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void batchInsetThreadTest() {
        List<UserDO> list = new ArrayList<>();
        for (int i = 200000; i < 300000; i++) {
            UserDO userDO = new UserDO();
            userDO.setName("名字" + i);
            userDO.setMobile("手机" + i);
            userDO.setEmail("邮箱" + i);
            userDO.setStatus(1);
            list.add(userDO);
        }
        long start = System.currentTimeMillis();
        int batchSize = 1000;
        // 使用 lambda 表达式将 userList 每1000个元素分为一组
        List<List<UserDO>> groupedBakUsers = IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.groupingBy(index -> index / batchSize)) // 将索引按组分组
                .values()
                .stream()
                .map(indices -> indices.stream()
                        .map(list::get) // 根据索引获取 User 对象
                        .collect(Collectors.toList())) // 每组1000个元素的列表
                .collect(Collectors.toList()); // 所有分组的列表
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        int i = 1;
        for (List<UserDO> groupedBakUser : groupedBakUsers) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                for (UserDO userDO : groupedBakUser) {
                    userService.insert(userDO);
                }
            });
            i++;
            completableFutureList.add(completableFuture);
        }
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[]{})).join();
        System.out.println(System.currentTimeMillis() - start);
    }

}
