package com.example.helloserver.service;

public class HelloWorldImpl implements  HelloWorldService.Iface{
    @Override
    public String sayHello(String username) {
        return "Hi," + username + " welcome to jianshu";
    }
}
