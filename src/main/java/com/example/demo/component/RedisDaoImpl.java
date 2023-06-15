package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisDaoImpl {

    @Autowired
    private JedisCluster getRedisCluster;

    public void setKeyInRedis(String key, String value) {
        getRedisCluster.set(key, value);
    }

    public String getValueByKey(String key) {
        return (String) getRedisCluster.get(key);
    }
}


