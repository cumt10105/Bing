package com.example.demo.spring.redis;

import com.example.demo.spring.service.RedisMessagePublisher;
import com.example.demo.spring.service.RedisMessagePublisherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

//@Configuration
//@ComponentScan("com.example.demo.spring.service")
//@PropertySource("classpath:application.properties")
public class RedisConfig {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//        return template;
//    }
//
//    @Bean
//    ChannelTopic topic() {
//        return new ChannelTopic("messageQueue");
//    }
//
//    @Bean
//    RedisMessagePublisher redisPublisher() {
//        return new RedisMessagePublisherImpl();
//    }
}
