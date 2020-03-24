package com.giado.demo.repositories;

import com.giado.demo.model.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Art, Long>, JpaRepository<Art, Long> {
//    @Query("select new com.giado.demo.model.Album(a.name) from Art a, Purchase p where a.id = p.id")
//    List<Album> displayAllArtName();
}
