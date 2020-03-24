package com.giado.demo.services;

import com.giado.demo.model.Purchase;
import com.giado.demo.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        Iterable<Purchase> it = purchaseRepository.findAll();
        List<Purchase> result = new ArrayList<>();
        for (Purchase purchase : it) {
            result.add(purchase);
        }
        return result;
    }
}
