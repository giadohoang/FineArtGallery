package com.giado.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
public class Buyer extends User{

    public Buyer(){};

    public Buyer(String userName,String firstName, String lastName, UserType type,List<Art> portfolio){
        super(userName,firstName, lastName, type);
        this.collections = portfolio;
    }

    //@OneToMany
    private List<Art> collections = new ArrayList<>();

    public List<Art> getCollections() {
        return collections;
    }


    public void setCollections(List<Art> collections) {
        this.collections = collections;
    }
}
