package com.example.demo.config;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Connection;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SpringConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port0}")
    private int port0;
    @Value("${redis.port1}")
    private int port1;
    @Value("${redis.port2}")
    private int port2;
    @Value("${redis.port3}")
    private int port3;
    @Value("${redis.port4}")
    private int port4;
    @Value("${redis.port5}")
    private int port5;


    @Value("${redis.password}")
    private String password;

    @Value("${redis.jedis.pool.max-total}")
    private int maxTotal;

    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;


    @Bean
    public JedisCluster getRedisCluster(){
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort(host, port0));
        jedisClusterNode.add(new HostAndPort(host, port1));
        jedisClusterNode.add(new HostAndPort(host, port2));
        jedisClusterNode.add(new HostAndPort(host, port3));
        jedisClusterNode.add(new HostAndPort(host, port4));
        jedisClusterNode.add(new HostAndPort(host, port5));

        GenericObjectPoolConfig<Connection> cfg = new GenericObjectPoolConfig<Connection>();
        cfg.setMaxTotal(maxTotal);
        cfg.setMaxIdle(maxIdle);
        cfg.setMaxWaitMillis(10000);
        cfg.setTestOnBorrow(true);
        JedisCluster jc = new JedisCluster(jedisClusterNode, 10000, 1, cfg);
        jc.set("123","Shrey");
        System.out.println(jc.get("123"));
        return jc;
    }



}