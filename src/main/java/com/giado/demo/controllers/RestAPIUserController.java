package com.giado.demo.controllers;

import com.giado.demo.model.User;
import com.giado.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAPIUserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.getAll();

        return users;
    }
//    @GetMapping("/user/login/{userName}")
//    public User findUserByUsername(@PathVariable("userName") String userName) {
//        return userService.findUserByUsername(userName);
//    }


}
