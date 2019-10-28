package com.example.helloserver;

import com.example.helloserver.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloserverApplicationTests {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        try {
            userService.testBatch();
        } catch (Exception e) {
            System.out.println("catch:" + e.getMessage());
        }
    }

}
