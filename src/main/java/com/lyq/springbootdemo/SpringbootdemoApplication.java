package com.lyq.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootdemoApplication {
//public class SpringbootdemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run( SpringbootdemoApplication.class, args );
    }

    // 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。

    //@Override
    //protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //    return builder.sources( SpringbootdemoApplication.class );
    //}
}
