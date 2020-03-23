package com.giado.demo.repositories;

import com.giado.demo.model.Album;
import com.giado.demo.model.Art;
import com.giado.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Art, Long> {
    @Query("select new com.giado.demo.model.Album(a.name) from Art a, Purchase p where a.id = p.id")
    List<Album> displayAllArtName();
}
