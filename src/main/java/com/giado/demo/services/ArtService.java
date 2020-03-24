package com.giado.demo.services;

import com.giado.demo.model.Art;
import com.giado.demo.repositories.AlbumRepository;
import com.giado.demo.repositories.ArtRepository;
import com.giado.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtService {
    @Autowired
    private ArtRepository artRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AlbumRepository albumRepository;

    public List<Art> getAll() {
        Iterable<Art> it = artRepository.findAll();
        List<Art> result = new ArrayList<>();
        for (Art art : it) {
            result.add(art);
        }
        return result;
    }

}
