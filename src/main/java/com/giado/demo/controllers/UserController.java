package com.giado.demo.controllers;

import com.giado.demo.model.User;
import com.giado.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/user/portfolio/{user_id}"})
    public String viewPortfolio(ModelMap model, @PathVariable Long user_id) {
        Optional<User> user = userService.geUdserById(user_id);
        if(user.isPresent()){
            model.addAttribute("id", user.get().getId());
            return "portfolio";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping(value = {"/user/collection/{user_id}"})
    public String viewCollection(ModelMap model, @PathVariable Long user_id) {
        Optional<User> user = userService.geUdserById(user_id);
        if(user.isPresent()){
            model.addAttribute("id", user.get().getId());
            return "collection";
        } else {
            return "redirect:/index";
        }

    }
}
