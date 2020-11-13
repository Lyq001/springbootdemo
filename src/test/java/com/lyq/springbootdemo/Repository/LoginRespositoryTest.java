package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
class LoginRespositoryTest {

    @Autowired
    private LoginRespository loginRespository;

    @Test
    public String login(){
        User user = new User();
        user.setUsername( "test" );
        user.setPassword( "123" );
        System.out.println(user);
        Example<User> userExample = Example.of( user );

        boolean exists = loginRespository.exists(userExample);
        System.out.println(exists);
        return "";
    }

}