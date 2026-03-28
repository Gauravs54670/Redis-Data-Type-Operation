package com.gaurav.RedisDataType.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SetService {
    /**
     * SET Data Type
     * ─────────────────────────────────────────────
     * Unordered collection of UNIQUE values. No duplicates.
     * Use cases:
     *   - Track which passengers are boarded on a ride
     *   - Store unique active ride IDs
     *   - Prevent duplicate requests (check membership)
     */
    private final RedisTemplate<String, Object> redisTemplate;
    public SetService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
//    add member to set (duplicates ignored automatically)
    public Long addMember(String key, String value) {
        return this.redisTemplate.opsForSet().add(key,value);
    }
//    get members
    public Set<Object> getMembers(String key) {
        return this.redisTemplate.opsForSet().members(key);
    }
//    is member exist
    public Boolean isMemberExist(String key, String value) {
        return this.redisTemplate.opsForSet().isMember(key, value);
    }
//    remove member
    public Long removeMember(String key, String value) {
        return this.redisTemplate.opsForSet().remove(key,value);
    }
//    get size
    public Long getSize(String key) {
        return this.redisTemplate.opsForSet().size(key);
    }
//    Intersect two sets
    public Set<Object> intersectSets(String key1, String key2) {
        return this.redisTemplate.opsForSet().intersect(key1, key2);
    }
//    Union two sets
    public Set<Object> unionSets(String key1, String key2) {
        return this.redisTemplate.opsForSet().union(key1, key2);
    }
}
