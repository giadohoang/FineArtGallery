package com.giado.demo.model;


import javax.persistence.Column;

public class Album {
    public Album(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
