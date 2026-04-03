package com.gaurav.RedisDataType.controller;

import com.gaurav.RedisDataType.service.SortedSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sorted-set")
public class SortedSetController {
    @Autowired
    private SortedSetService sortedSetService;
//    add member with score
    @PostMapping("/add")
    public ResponseEntity<String> addMember(
            @RequestParam("key") String key,
            @RequestParam("member") String member,
            @RequestParam("score") double score) {
        this.sortedSetService.addMemberWithScore(key,member,score);
        return ResponseEntity.ok(member + " added with score " + score);
    }
}
