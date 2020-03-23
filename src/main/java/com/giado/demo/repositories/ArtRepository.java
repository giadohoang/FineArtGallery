package com.giado.demo.repositories;

import com.giado.demo.model.Art;
import com.giado.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtRepository extends JpaRepository<Art, Long> {
    List<Art> findByUserId(@Param("user_id") Long user_id);
    List<Art> findAllByUserId(@Param("user_id") Long user_id);
   // @Query("select a from Art a, Purchase p where a.id = p.id and p.user.id = ?1")
   //List<Art> findAllByUserId(@Param("user_id") Long user_id);
}
