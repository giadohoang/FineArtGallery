package com.giado.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "art")
public class Art  {

    public Art() {
    }
    public Art(String name, String url, User user, Year year, String description, double price, int width, int height, Purchase purchase) {
        this.name = name;
        this.url = url;
        this.user = user;
        this.year = year;
        this.description = description;
        this.price = price;
        this.width = width;
        this.height= height;
        this.purchase = purchase;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name ="name")
    private String name;

    @Column(name="url")
    private String url;

    @Column(name="year", nullable = true)
    private Year year;

    @Column(name="description", nullable = true)
    private String description;

    @Column(name="price", nullable = true)
    private double price;

    @Column(name="width", nullable = true)
    private int width;

    @Column(name="height", nullable = true)
    private int height;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "art")
    private Purchase purchase = new Purchase();

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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
