package com.giado.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    public User(){};

    public User(String userName, String firstName, String lastName,  UserType type){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name="type")
    private UserType type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
    //art create
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Art> portfolios = new HashSet<>();

    //art purchases
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Purchase> collections = new HashSet<>();
}
