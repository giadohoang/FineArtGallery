package com.giado.demo.model;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Buyer extends User {

    //@OneToMany
    private List<Art> collections = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(String userName, String firstName, String lastName, int type, List<Art> portfolio) {
        super(userName, firstName, lastName, type);
        this.collections = portfolio;
    }

    public List<Art> getCollections() {
        return collections;
    }


    public void setCollections(List<Art> collections) {
        this.collections = collections;
    }
}
