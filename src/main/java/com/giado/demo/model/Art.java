package com.giado.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "art")
@JsonIgnoreProperties({"purchase", "hibernateLazyInitializer", "handler"})
public class Art implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;
//    @JsonBackReference
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private User user;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "year", nullable = true)
    private int year;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "price", nullable = true)
    private double price;
    @Column(name = "width", nullable = true)
    private int width;
    @Column(name = "height", nullable = true)
    private int height;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "art", fetch = FetchType.LAZY)
    @JsonIgnore
    private Purchase purchase;

    public Art() {
    }

    public Art(String name, String url, int year, String description, int price, int width, int height) {
        this.name = name;
        this.url = url;
        this.year = year;
        this.description = description;
        this.price = price;
        this.width = width;
        this.height = height;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @JsonIgnore
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
