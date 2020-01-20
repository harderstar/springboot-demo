package com.simdy.web.springbootredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author simdy
 * @time 2019/8/13
 */
@Service
public class ReceiverService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getMessage() {
        String value = redisTemplate.opsForList().rightPop("quere");
        return value;
    }
}

