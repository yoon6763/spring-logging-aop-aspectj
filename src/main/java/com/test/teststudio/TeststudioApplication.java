package com.test.teststudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class TeststudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeststudioApplication.class, args);
    }

}
