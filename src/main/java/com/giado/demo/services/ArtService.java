package com.giado.demo.services;

import com.giado.demo.model.Album;
import com.giado.demo.model.Art;
import com.giado.demo.repositories.AlbumRepository;
import com.giado.demo.repositories.ArtRepository;
import com.giado.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ArtService {
    @Autowired
    private ArtRepository artRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AlbumRepository albumRepository;

    public List<Art> findArtByArtist(Long user_id) {
        //java.util.List<Art> li = artRepository.findByUserId(user_id);
        //List<Art> li  = artRepository.findByUserId(user_id);
        List<Art> lia  = artRepository.findAll();
        return lia;
    }

    public List<Album> findAllName(){
        return albumRepository.displayAllArtName();
    }

    public List<Art> findArtByBuyer(Long user_id) {

        List<Art> li = artRepository.findAllByUserId(user_id);
        //java.util.List<Art> li = artRepository.findByUserId(user_id);
        return  li;
    }
}
