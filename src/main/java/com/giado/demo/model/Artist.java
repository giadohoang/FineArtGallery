package com.giado.demo.model;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Artist extends User {

    //@OneToMany
    private List<Art> portfolio = new ArrayList<>();

    public Artist() {
    }

    public Artist(String userName, String firstName, String lastName, int type, List<Art> portfolio) {
        super(userName, firstName, lastName, type);
        this.portfolio = portfolio;
    }

    public List<Art> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Art> portfolio) {
        this.portfolio = portfolio;
    }
}
