package com.example.demo.spring.service;

public interface RedisMessagePublisher {
    void publish(final String message);
}
