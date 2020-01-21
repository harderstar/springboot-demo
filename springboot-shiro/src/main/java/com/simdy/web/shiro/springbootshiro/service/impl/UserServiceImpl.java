package com.simdy.web.shiro.springbootshiro.service.impl;

import com.simdy.web.shiro.springbootshiro.entity.User;
import com.simdy.web.shiro.springbootshiro.service.UserService;
import com.simdy.web.shiro.springbootshiro.shiro.ShiroUtil;
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

        return "6917d5c6746ec8355cdcdacd4c486e9e";
    }

    @Override
    public boolean forbidden(String username) {
        return false;
    }

    @Override
    public boolean auth(String username, String password) {
        if(findByUserName(username) == null)
            return false;
        if(ShiroUtil.md5(password,"0n9u3fvdv9hrenvu0m309mv").equals(getPassword(username)))
            return true;
        return false;
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
