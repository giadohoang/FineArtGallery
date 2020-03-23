package com.giado.demo.controllers;

import com.giado.demo.model.Album;
import com.giado.demo.model.Art;
import com.giado.demo.model.User;
import com.giado.demo.repositories.ArtRepository;
import com.giado.demo.repositories.UserRepository;
import com.giado.demo.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RestAPIArtController {
  @Autowired
    ArtService artService;
    @GetMapping("/art/sellers/{user_id}")
    public List<Album> findArtByArtist(@PathVariable("user_id") Long user_id) {
       List<Album> li = (ArrayList<Album>) artService.findAllName();
       return li;
    }

    @GetMapping("/art/buyers/{user_id}")
    public List<Art> findArtByid(@PathVariable("user_id") Long user_id) {
        List<Art> li = artService.findArtByBuyer(user_id);
        return li;
    }
}
