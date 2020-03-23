package com.giado.demo.repositories;

import com.giado.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<User, Long> {
}
