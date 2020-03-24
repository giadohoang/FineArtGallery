package com.giado.demo.services;

import com.giado.demo.model.User;
import com.giado.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        Iterable<User> it = userRepository.findAll();
        List<User> result = new ArrayList<>();
        for (User user : it) {
            result.add(user);
        }
        return result;
    }

//    public User findUserByUsername(String userName) {
//        User currentUser = new User();
//        List<User> li = userRepository.findByUserName(userName);
//        if(li.size() > 0){
//            return li.get(0);
//        } else {
//            return currentUser;
//        }
//    }
}
