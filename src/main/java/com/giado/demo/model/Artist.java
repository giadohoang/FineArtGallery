package com.giado.demo.model;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
public class Artist extends User {

    public Artist(){};

    public Artist(String userName,String firstName, String lastName, UserType type,List<Art> portfolio){
        super(userName,firstName, lastName, type);
        this.portfolio = portfolio;
    }

    //@OneToMany
    private List<Art> portfolio = new ArrayList<>();

    public List<Art> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Art> portfolio) {
        this.portfolio = portfolio;
    }
}
