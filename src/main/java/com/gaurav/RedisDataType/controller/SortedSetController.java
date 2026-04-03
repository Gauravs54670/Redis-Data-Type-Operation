package com.gaurav.RedisDataType.controller;

import com.gaurav.RedisDataType.service.SortedSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
//    get member's score
    @GetMapping("/get-score")
    public ResponseEntity<?> getScore(
            @RequestParam("key") String key,
            @RequestParam("member") String member) {
        Object response = this.sortedSetService.getScore(key, member);
        return ResponseEntity.ok("Response: " + response);
    }
//    get the rank of member
    @GetMapping("/get-rank")
    public ResponseEntity<?> getRank(
            @RequestParam("key") String key,
            @RequestParam("member") String member) {
        Long result = this.sortedSetService.getRankOfMember(key, member);
        return ResponseEntity.ok(
                result != null? "Member rank is: " + result : "No member found. Rank is null"
        );
    }
//    get all the members in ascending order
    @GetMapping("/all-acs-members")
    public ResponseEntity<?> getMembersInAscending(@RequestParam("key") String key) {
        Set<Object> response = this.sortedSetService.getAllMembersInAscending(key);
        return ResponseEntity.ok(
                (response == null || response.isEmpty()) ?
                        "No member present." : response);
    }
    //    get all the members in ascending order
    @GetMapping("/all-desc-members")
    public ResponseEntity<?> getMembersInDescending(@RequestParam("key") String key) {
        Set<Object> response = this.sortedSetService.getAllMembersInDescending(key);
        return ResponseEntity.ok(
                (response == null || response.isEmpty()) ?
                        "No member present." : response);
    }
}
