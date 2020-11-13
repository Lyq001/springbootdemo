package com.lyq.springbootdemo.Controller;

import com.lyq.springbootdemo.Entity.User;
import com.lyq.springbootdemo.Repository.LoginRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginRespository loginRespository;

    @PostMapping("/loginIn")
    public String login(@RequestBody User user){
        Example<User> userExample = Example.of( user );
        boolean exists = loginRespository.exists(userExample);
        System.out.println(exists);
        if(exists){
            return "success";
        }else{
            return "error";
        }


    }
}
