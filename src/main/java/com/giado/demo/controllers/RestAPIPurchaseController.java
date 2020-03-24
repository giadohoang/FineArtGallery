package com.giado.demo.controllers;

import com.giado.demo.model.Purchase;
import com.giado.demo.model.User;
import com.giado.demo.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAPIPurchaseController {
    @Autowired
    PurchaseService purchaseService;
    @GetMapping("/allPurchases")
    public List<Purchase> getAllPurchases() {
        List<Purchase> purchases = purchaseService.getAll();

        return purchases;
    }
}
