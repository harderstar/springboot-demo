package com.simdy.web.shiro.springbootshiro.service.impl;

import com.simdy.web.shiro.springbootshiro.entity.User;
import com.simdy.web.shiro.springbootshiro.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Simdy
 * @Date: Created on 2020/1/20 16:54
 * @Version: 0.0.1
 * @Modified By:
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUserName(String userName) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        return user;
    }

    @Override
    public String getPassword(String userName) {
        return "123456";
    }

    @Override
    public int checkUserBanStatus(String username) {
        return 0;
    }

    @Override
    public String getRole(String username) {
        return "user";
    }

    @Override
    public String getRolePermission(String role) {
        return "user";
    }

    @Override
    public String getPermission(String username) {
        return "msg";
    }
}
