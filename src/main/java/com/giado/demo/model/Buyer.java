package com.giado.demo.model;

import java.util.List;

//@Entity
public class Buyer extends User {

    //@OneToMany
    private List<Purchase> collections;

    public Buyer() {
    }

    public Buyer(String userName, String firstName, String lastName, int type, List<Purchase> collections) {
        super(userName, firstName, lastName, type);
        this.collections = collections;
    }

    public List<Purchase> getCollections() {
        return collections;
    }


    public void setCollections(List<Purchase> collections) {
        this.collections = collections;
    }
}
