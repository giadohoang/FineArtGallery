package com.giado.demo.model;

import javax.persistence.*;
import java.time.Year;


@Entity
@Table(name = "art")
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "art")
    private Purchase purchase = new Purchase();
}
