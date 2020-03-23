package com.giado.demo.repositories;

import com.giado.demo.model.Purchase;
import com.giado.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
