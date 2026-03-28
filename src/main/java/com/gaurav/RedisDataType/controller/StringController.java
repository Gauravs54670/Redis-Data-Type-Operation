package com.gaurav.RedisDataType.controller;

import com.gaurav.RedisDataType.service.StringService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/string")
public class StringController {
    private final StringService service;
    public StringController(StringService service) {
        this.service = service;
    }
//    get key-value
    @GetMapping("/get-key")
    public ResponseEntity<?> getValue(@RequestParam("key") String key) {
        return ResponseEntity.ok("Value is " + this.service.getKey(key));
    }
//    set key-value
    @PostMapping("/set-key")
    public ResponseEntity<?> setKeyValue(
            @RequestParam("key") String key, @RequestParam("value") String value) {
        this.service.setKeyValue(key, value);
        return ResponseEntity.ok("Saved " + key +" = " + value);
    }
//    set key-value with TTL
    @PostMapping("/set-key-ttl")
    public ResponseEntity<?> setKeyValueTTL(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") Long time) {
        this.service.setKeyValueTTL(key, value, time);
        return ResponseEntity.ok("Saved " + key + " " + value +" for " + time +" seconds.");
    }
//    delete key
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("key") String key) {
        return ResponseEntity.ok(this.service.deleteKey(key) ? key +" is deleted." : "Key deletion failed.");
    }
//    check key exist
    @GetMapping("/key-exist")
    public ResponseEntity<?> keyExist(@RequestParam("key") String key) {
        return ResponseEntity.ok(this.service.keyExist(key) ? key +" exist" : key +" not exist.");
    }
}
