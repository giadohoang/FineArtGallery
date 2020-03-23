package com.giado.demo.repositories;

import com.giado.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User,Long> {
    List<User> findByUserName(@Param("username") String userName);
    List<User>  findUserById(@Param("user_id") Long user_id);
}
