package com.demo.controller;

import com.demo.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lw on 16-11-10.
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/login")
public class LoginController {
    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, String s){
        System.out.println("user: " + user.getName() + " password: " + user.getPassword() + " s: " + s);
        return user.getName();
    }
}
