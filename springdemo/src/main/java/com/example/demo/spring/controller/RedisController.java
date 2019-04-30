package com.example.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/set/{key}:{value}")
    public String setValue(@PathVariable String key, @PathVariable String value){
        redisTemplate.opsForValue().set(key, value);
        return redisTemplate.opsForValue().get(key)==null?"":redisTemplate.opsForValue().get(key).toString();
    }

    @RequestMapping("/push/{message}")
    public String push(@PathVariable String message) throws InterruptedException {
        //String message = "Message " + UUID.randomUUID();
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Thread.sleep(100);
        return stringRedisTemplate.opsForValue().get("aaa");
    }
}
