package com.simdy.web.shiro.springbootshiro.service;

import com.simdy.web.shiro.springbootshiro.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: Simdy
 * @Date: Created on 2020/1/20 16:40
 * @Version: 0.0.1
 * @Modified By:
 * @Description:
 */
@CacheConfig(cacheNames = "user")
public interface UserService {
    @Cacheable(key = "'userName'.concat(#userName)")
    User findByUserName(String userName);

    @Cacheable(key = "'userName'.concat(#userName)")
    String getPassword(String userName);

    boolean forbidden(String username);

    boolean auth(String username,String password);

    int checkUserBanStatus(String username);

    String getRole(String username);
    String getRolePermission(String role);
    String getPermission(String username);
}
