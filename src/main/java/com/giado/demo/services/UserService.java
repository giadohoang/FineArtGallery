package com.giado.demo.services;

import com.giado.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


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
