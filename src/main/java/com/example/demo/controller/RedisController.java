package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private JedisCluster jedisCluster;

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        return jedisCluster.get(key);
    }

    @PostMapping("/set")
    public void setValue(@RequestParam String key, @RequestParam String value) {
        jedisCluster.set(key, value);
    }

    @DeleteMapping("/delete/{key}")
    public Long deleteValue(@PathVariable String key) {
        return jedisCluster.del(key);
    }
}

