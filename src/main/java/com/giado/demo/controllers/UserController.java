package com.giado.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value = {"/user/viewArt"})
    public String viewArt() {
        return "viewArt";
    }
}
