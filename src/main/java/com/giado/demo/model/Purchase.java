package com.giado.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
@JsonIgnoreProperties({"art", "hibernateLazyInitializer", "handler"})
public class Purchase implements java.io.Serializable {
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    public User user;

    @OneToOne
    @JoinColumn(name = "art_id")
    public Art art;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    public Purchase() {
    }

    public Purchase(User user, Art art) {
        this.user = user;
        this.art = art;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }
}
