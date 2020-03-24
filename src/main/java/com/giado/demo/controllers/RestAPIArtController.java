package com.giado.demo.controllers;

import com.giado.demo.model.Art;
import com.giado.demo.model.Purchase;
import com.giado.demo.model.User;
import com.giado.demo.services.ArtService;
import com.giado.demo.services.PurchaseService;
import com.giado.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestAPIArtController {
    @Autowired
    private ArtService artService;
    @Autowired
    private UserService userService;
    @Autowired
    private PurchaseService purchaseService;

    //    @GetMapping("/allArts")
//    public List<Art> getAllArts() {
//        List<Art> arts = artService.getAll();
//
//        return arts;
//    }
//    @GetMapping("/allArts")
//    public JsonData getAllArts() {
//        List<Art> arts = artService.getAll();
//        List<User> users = userService.getAll();
//        List<Purchase> purchases = purchaseService.getAll();
//        JsonData jsonData = new JsonData(users, arts, purchases);
//        return jsonData;
//    }
    @GetMapping("/allArts")
    public List<Art> getAllArts() {
        List<Art> arts = artService.getAll();

        return arts;
    }
//    @GetMapping("/art/sellers/{user_id}")
//    public List<Album> findArtByArtist(@PathVariable("user_id") Long user_id) {
//       List<Album> li = (ArrayList<Album>) artService.findAllName();
//       return li;
//    }
//
//    @GetMapping("/art/buyers/{user_id}")
//    public List<Art> findArtByid(@PathVariable("user_id") Long user_id) {
//        List<Art> li = artService.findArtByBuyer(user_id);
//        return li;
//    }
//
//    @GetMapping({"/art/", "/art"})
//    public List<Art> getAllArt(){
//        List<Art> li = artService.findAllArt();
//        return li;
//    }
}

class JsonData {
    List<User> users;
    List<Art> arts;
    List<Purchase> purchases;

    public JsonData() {
    }

    public JsonData(List<User> users, List<Art> arts, List<Purchase> purchases) {
        this.users = users;
        this.arts = arts;
        this.purchases = purchases;
    }
}