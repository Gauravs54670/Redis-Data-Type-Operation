package com.gaurav.RedisDataType.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    /*
      * LIST Data Type
     * ─────────────────────────────────────────────
     * Ordered collection. Can push/pop from both ends.
     * Think of it like a LinkedList or Queue/Stack.
     * Use cases:
     *  - Driver request queue (FIFO — first request, first seen)
     *  - Ride history / activity feed
     *  - Recent searches
     */
    private final RedisTemplate<String, Object> redisTemplate;
    public ListService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
//    Push to LEFT (beginning) of list
//    e.g., L-PUSH ride:queue "request_1"
    public Long pushLeft(String key, String value) {
        return redisTemplate.opsForList().leftPush(key,value);
    }
//    Push to RIGHT (end) of list - like enqueue
//    e.g., R-PUSH ride:queue "request_1"
    public Long pushRight(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }
//    Pop from LEFT — like dequeue (FIFO when combined with R-PUSH)
//    e.g., L-POP ride:queue
    public Object popLeft(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }
//    Pop from RIGHT - like enqueue
    public Object popRight(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }
//    get all element of list
    public List<Object> getAllElement(String key) {
        return redisTemplate.opsForList().range(key,0,-1);
    }
//    get size of list
    public Long getSize(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
