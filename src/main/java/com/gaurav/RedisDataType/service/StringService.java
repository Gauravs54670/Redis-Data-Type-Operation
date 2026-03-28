package com.gaurav.RedisDataType.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StringService {
    private final RedisTemplate<String, Object> redisTemplate;
    public StringService(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
//    get value from key
    public Object getKey(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
//    set a key-value in string
    public void setKeyValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
//    set key-value with ttl
    public void setKeyValueTTL(String key, String value, Long timeLimit) {
        redisTemplate.opsForValue().set(key, value, timeLimit, TimeUnit.SECONDS);
    }
//    delete key
    public Boolean deleteKey(String key) {
        return this.redisTemplate.delete(key);
    }
//    get expiry ttl for key
    public Long getTTL(String key) {
        return redisTemplate.getExpire(key);
    }
//    check if key exist
    public Boolean keyExist(String key) {
        return redisTemplate.hasKey(key);
    }
}
