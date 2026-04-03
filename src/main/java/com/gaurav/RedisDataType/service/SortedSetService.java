package com.gaurav.RedisDataType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SortedSetService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
//    add member with score
    public Boolean addMemberWithScore(
            String key, String member, double score) {
        return redisTemplate.opsForZSet().add(key, member, score);
    }
}
