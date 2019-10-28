package com.example.helloserver;

import com.example.helloserver.mapper.UserMapper;
import com.example.helloserver.model.User;
import com.example.helloserver.service.HelloWorldImpl;
import com.example.helloserver.service.HelloWorldService;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.AbstractProtocol;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.ServerSocket;

@SpringBootApplication
public class HelloserverApplication {

    public static void main(String[] args) throws IOException, TTransportException {
        ApplicationContext context = SpringApplication.run(HelloserverApplication.class, args);

        /*TServerTransport transport = new TServerSocket(8090);
        TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
        HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldImpl());
        tArgs.processor(processor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        tArgs.transportFactory(new TTransportFactory());
        tArgs.minWorkerThreads(50);
        tArgs.maxWorkerThreads(200);
        TServer server = new TThreadPoolServer(tArgs);
        System.out.println("Running server...");
        try {
            server.serve();
        } catch (Exception e) {

        }*/

//        UserMapper userMapper = context.getBean(UserMapper.class);
//        SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate)context.getBean(SqlSession.class);
//        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        for (int i = 3; i < 5; i++) {
//            User user = new User();
//            user.setName("tt"+i);
//            user.setAge(i);
//            user.setNo(i);
//            System.out.println(userMapper.insert(user));
//        }
//        User user = new User();
//        user.setId(13);
//        user.setNo(2);
//        System.out.println(userMapper.update(user));
//        sqlSession.commit();
    }

}

