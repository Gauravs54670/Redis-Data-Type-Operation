package com.gaurav.RedisDataType.controller;

import com.gaurav.RedisDataType.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    private ListService listService;
//    push from left
    @PostMapping("/push-left")
    public ResponseEntity<String> pushLeft(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        Long size = this.listService.pushLeft(key, value);
        return ResponseEntity.ok("Pushed to left. Left size: " + size);
    }
//    push to right
    @PostMapping("/push-right")
    public ResponseEntity<String> pushRight(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        Long size = this.listService.pushRight(key, value);
        return ResponseEntity.ok("Pushed to right. Right size: " + size);
    }
//    pop from left
    @PostMapping("/pop-left")
    public ResponseEntity<?> popLeft(@RequestParam("key") String key) {
        Object value = this.listService.popLeft(key);
        return ResponseEntity.ok(value != null? value : "List is empty");
    }
//    pop from right
    @PostMapping("/pop-right")
    public ResponseEntity<?> popRight(@RequestParam("key") String key) {
        Object value = this.listService.popRight(key);
        return ResponseEntity.ok(value != null? value : "List is empty");
    }
//    get all element of list
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllElements(@RequestParam("key") String key) {
        List<Object> list = this.listService.getAllElement(key);
        return ResponseEntity.ok(list.isEmpty() ? "List is empty" : list);
    }
//    get size of list
    @GetMapping("/get-size")
    public ResponseEntity<?> getSize(@RequestParam("key") String key) {
        Long size = this.listService.getSize(key);
        return ResponseEntity.ok(size != null? size : "List is empty");
    }
}
