package com.lm.blog.server.learn.proxy;

import java.util.Collections;
import java.util.List;

import com.lm.blog.server.model.UserDO;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 */
@Component
public class UserServiceObjectImpl {

    /**
     * find user list.
     *
     * @return user list
     */
    public List<UserDO> findUserList() {
        return Collections.singletonList(new UserDO("pdai", "pdai@qq.com"));
    }

    /**
     * add user
     */
    public void addUser() {
        // do something
    }

}