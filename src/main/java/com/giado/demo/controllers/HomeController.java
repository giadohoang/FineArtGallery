package com.giado.demo.controllers;

import com.giado.demo.services.ArtService;
import com.giado.demo.services.PurchaseService;
import com.giado.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final ArtService artService;
    private final PurchaseService purchaseService;
    public HomeController(UserService userService, ArtService artService, PurchaseService purchaseService){
        this.userService = userService;
        this.artService = artService;
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

}
