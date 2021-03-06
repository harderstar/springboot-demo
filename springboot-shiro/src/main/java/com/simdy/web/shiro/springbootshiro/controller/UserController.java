package com.simdy.web.shiro.springbootshiro.controller;

import com.simdy.web.shiro.springbootshiro.entity.vo.Msg;
import com.simdy.web.shiro.springbootshiro.service.UserService;
import com.simdy.web.shiro.springbootshiro.shiro.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

import static com.simdy.web.shiro.springbootshiro.shiro.JwtUtil.createToken;

/**
 * @Author: Simdy
 * @Date: Created on 2020/1/20 16:55
 * @Version: 0.0.1
 * @Modified By:
 * @Description:
 */
@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "登录--不进行拦截")
    public Msg login(String username,String password){
        Integer times = (Integer)redisTemplate.opsForHash().get("passwordError", username);
        if(times!=null && times == 5){
            userService.forbidden(username);
        }
        if (!userService.auth(username,password)) {
            if((times)!=null){
                redisTemplate.opsForHash().put("passwordError",username,++times);
            }else {
                redisTemplate.opsForHash().put("passwordError",username,1);
            }
            return Msg.fail().add("info","用户名错误或密码错误");
        } else {
            redisTemplate.opsForHash().put("passwordError",username,0);
            String token = JwtUtil.createToken(username);
            redisTemplate.opsForHash().put("token",username,token);
            return Msg.success().add("token",token);
        }
    }

    @ApiOperation(value = "无权限", notes = "无权限跳转的接口")
    @RequestMapping(path = "/unauthorized/{message}")
    public Msg unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return Msg.fail().add("info",message);
    }

    @ApiOperation(value = "特定用户访问", notes = "拥有 user, admin 角色的用户可以访问下面的页面")
    @PostMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user"})
    public Msg getMessage() {
        return Msg.success().add("info","成功获得信息！");
    }

    @ApiOperation(value = "Vip用户访问", notes = "拥有 vip 权限可以访问该页面")
    @PostMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user"})
    @RequiresPermissions("msg")
    public Msg getVipMessage() {
        return Msg.success().add("info","成功获得 vip 信息！");
    }

}
