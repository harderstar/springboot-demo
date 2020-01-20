package com.simdy.web.springbootmybatis.controller;

import com.simdy.web.springbootmybatis.bean.User;
import com.simdy.web.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Simdy
 * @Date: 2020/1/3 9:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id")Integer id){
        return userService.getById(id);
    }

    @PostMapping("/")
    public User insert(@ModelAttribute User user){
        return userService.create(user);
    }

    @PutMapping("/")
    public User update(@ModelAttribute User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id")Integer id){
         if(1 == userService.delete(id))
             return true;
         return false;
    }

}
