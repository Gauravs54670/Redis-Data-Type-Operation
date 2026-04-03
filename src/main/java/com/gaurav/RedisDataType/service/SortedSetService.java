package com.gaurav.RedisDataType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SortedSetService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
//    add member with score
    public void addMemberWithScore(
            String key, String member, double score) {
        redisTemplate.opsForZSet().add(key, member, score);
    }
//    get member and score
    public Object getScore(String key, String member) {
        return redisTemplate.opsForZSet().score(key, member);
    }
//    get the rank of member
    public Long getRankOfMember(String key, String member) {
        return redisTemplate.opsForZSet().rank(key, member);
    }
//    get all member in ascending order
    public Set<Object> getAllMembersInAscending(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }
//    get all member in descending order
    public Set<Object> getAllMembersInDescending(String key) {
        return redisTemplate.opsForZSet().reverseRange(key, 0, - 1);
    }

}
