package com.simdy.web.springbootswaggerui.serviceImpl;

import com.simdy.web.springbootswaggerui.bean.User;
import com.simdy.web.springbootswaggerui.dao.UserMapper;
import com.simdy.web.springbootswaggerui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abel
 * @ClassName UserServiceImpl
 * @date 2016年11月10日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param username
     * @return
     */
    @Override
    public User getUserByUserName(String username) {
        return userMapper.getByUsernameIs(username);
    }

    @Override
    public List<User> getByUsernameContaining(String username) {
        return userMapper.findByUsernameContaining(username);
    }

    @Override
    public User saveUser(User user) {
        if(1 == userMapper.insert(user))
            return user;
        throw new RuntimeException("insert error");
    }

    @Override
    public int removeUser(Long id) {
       try {
           userMapper.deleteById(id);
       }catch (Exception e) {
           return 0;
       }
        return 1;
    }

    @Override
    public User updateUser(User user) {
        if(1 == userMapper.updateById(user))
            return user;
        throw new RuntimeException("insert error");
    }

    @Override
    public User getUserById(Long id) {
        return  userMapper.selectById(id);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.selectList(null);
    }
}
