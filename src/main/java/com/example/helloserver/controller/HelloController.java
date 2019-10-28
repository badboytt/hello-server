package com.example.helloserver.controller;

import com.example.helloserver.model.User;
import com.example.helloserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/say")
    public User say(@RequestBody User user){
        try {
            Thread.sleep(19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User us = new User();
        us.setName("hello, 我是" + user.getName());
        System.out.println(user.getName());
        return us;
    }

    @PostMapping(value = "/sayDelay")
    public String sayDelay(@RequestBody String user){
        long sleep = Long.parseLong(user);
        if (sleep <= 0){
            return user + System.currentTimeMillis();
        }
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user + System.currentTimeMillis();
    }

    @PostMapping(value = "/sayRandom")
    public String sayRandom(@RequestBody String user){
        int count = user.length();
        return RandomStringUtils.random(count, true, false);
    }

    @GetMapping(value = "/select")
    public String select(@RequestParam String type, HttpServletResponse response){
        long start = System.nanoTime();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        response.setStatus(HttpServletResponse.);
//        userService.testBatch();
//        String m = "这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb这是1kb";
//        map.put("type",  type);
        System.out.println("cost:" + (System.nanoTime()- start) + " type:" + type);
        return "this is "+type;
    }
}
