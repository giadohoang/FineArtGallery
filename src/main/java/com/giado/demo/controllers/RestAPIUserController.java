package com.giado.demo.controllers;

import com.giado.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIUserController {

    @Autowired
    UserService userService;
//    @GetMapping("/user/login/{userName}")
//    public User findUserByUsername(@PathVariable("userName") String userName) {
//        return userService.findUserByUsername(userName);
//    }


}
