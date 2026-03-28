package com.gaurav.RedisDataType.controller;

import com.gaurav.RedisDataType.service.SetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/set")
public class SetController {

    @Autowired
    private SetService setService;
//    add member to set
    @PostMapping("/add-member")
    public ResponseEntity<?> addMember(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        return ResponseEntity.ok(this.setService.addMember(
                key,value) + " \nMember added.");
    }
//    get all members
    @GetMapping("/get-all")
    public ResponseEntity<?> getMembers(
            @RequestParam("key") String key){
        Set<Object> set = this.setService.getMembers(key);
        return ResponseEntity.ok(set != null? set : "Set is empty");
    }
//    check is member exist
    @GetMapping("/member-exist")
    public ResponseEntity<?> checkMemberExist(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        return ResponseEntity.ok(this.setService.isMemberExist(key,value));
    }
//    remove member
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMember(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        Long val = this.setService.removeMember(key, value);
        return ResponseEntity.ok(val != null? val : "Member not exist");
    }
//    get size of set
    @GetMapping("/size")
    public ResponseEntity<?> getSize(@RequestParam("key") String key) {
        return ResponseEntity.ok("Size of set is: " + this.setService.getSize(key));
    }
//    intersect two sets
    @PostMapping("/intersect")
    public ResponseEntity<Set<Object>> intersectSets(
            @RequestParam("key1") String key1,
            @RequestParam("key2") String key2) {
        return ResponseEntity.ok(this.setService.intersectSets(key1, key2));
    }
//    union two sets
    @PostMapping("/union")
    public ResponseEntity<Set<Object>> unionSets(
            @RequestParam("key1") String key1,
            @RequestParam("key2") String key2) {
        return ResponseEntity.ok(this.setService.unionSets(key1, key2));
    }
}
