package com.giado.demo.repositories;

import com.giado.demo.model.Art;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtRepository extends CrudRepository<Art, Long> {

//    List<Art> findByUserId(@Param("user_id") Long user_id);
//    List<Art> findAllByUserId(@Param("user_id") Long user_id);
//   // @Query("select a from Art a, Purchase p where a.id = p.id and p.user.id = ?1")
//   //List<Art> findAllByUserId(@Param("user_id") Long user_id);

}
