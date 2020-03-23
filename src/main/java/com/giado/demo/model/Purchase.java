package com.giado.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

    public Purchase(){};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "art_id")
    private Art art;
}
