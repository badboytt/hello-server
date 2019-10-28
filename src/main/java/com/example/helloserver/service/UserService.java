package com.example.helloserver.service;

import com.example.helloserver.mapper.UserMapper;
import com.example.helloserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void testBatch(){
        /*List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("tt"+i);
            user.setAge(i);
            user.setNo(i);
            user.setId((long)i);
            users.add(user);
        }
        User user = new User();
        user.setName("tt"+6);
        user.setAge(6);
        user.setNo(6);
        user.setId(391549156218372097l);
        users.add(user);
        System.out.println(userMapper.insertBatch(users));*/
        User user = new User();
        user.setNo(0);
        user.setAge(4);
        System.out.println(userMapper.update(user));
//
//        user = new User();
//        user.setId(391629249406042113l);
//        user.setName("tt12");
//        user.setAge(12);
//        user.setNo(12);
//        System.out.println(userMapper.insert(user));
    }
}
