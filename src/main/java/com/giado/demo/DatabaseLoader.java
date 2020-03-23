package com.giado.demo;

import com.giado.demo.model.User;
import com.giado.demo.model.UserType;
import com.giado.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PurchaseRepository purchaseRepository;
    private final ArtistRepository artistRepository;
    private final BuyerRepository buyerRepository;
    private final ArtRepository artRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository, PurchaseRepository purchaseRepository, ArtistRepository artistRepository, BuyerRepository buyerRepository, ArtRepository artRepository){
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
        this.artistRepository = artistRepository;
        this.buyerRepository = buyerRepository;
        this.artRepository = artRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User("john", "john","doe", UserType.ARTIST));
        this.userRepository.save(new User("janny", "janny","Peters", UserType.ARTIST));
        this.userRepository.save(new User("tim", "Tim","Johns", UserType.ARTIST));

        this.userRepository.save(new User("buyer1", "buyer1","Peters", UserType.BUYER));
        this.userRepository.save(new User("buyer2", "buyer2","Johns", UserType.BUYER));


    }
}
