package com.giado.demo;

import com.giado.demo.model.Art;
import com.giado.demo.model.Purchase;
import com.giado.demo.model.User;
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
    public DatabaseLoader(UserRepository userRepository, PurchaseRepository purchaseRepository, ArtistRepository artistRepository, BuyerRepository buyerRepository, ArtRepository artRepository) {
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
        this.artistRepository = artistRepository;
        this.buyerRepository = buyerRepository;
        this.artRepository = artRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("jDoe", "john", "doe", 1);
        Art art1 = new Art("The Silent", "http://somephotosource.com/theSilent", 2001, "This Painting is about Silence", 1234, 12, 8);
        art1.setUser(user1);
        user1.getPortfolios().add(art1);
        Art art2 = new Art("The Hill", "http://somephotosource.com/theHill", 1991, "This Painting is about Hills", 3321, 10, 10);
        art2.setUser(user1);
        user1.getPortfolios().add(art2);
        userRepository.save(user1);

        User user2 = new User("janny", "janny", "Danny", 1);
        Art art3 = new Art("The Night", "http://somephotosource.com/theNight", 2008, "This Painting is about Nights", 336, 25, 30);
        art3.setUser(user2);
        user2.getPortfolios().add(art3);
        userRepository.save(user2);

        User user3 = new User("tJohns", "Timothy", "Johns", 1);
        Art art4 = new Art("The Day", "http://somephotosource.com/theDay", 1991, "This Painting is about Day", 456, 10, 10);
        art4.setUser(user3);
        user3.getPortfolios().add(art4);
        userRepository.save(user3);

        User user4 = new User("daniel", "daniel", "Sync", 1);
        Art art5 = new Art("The Noon", "http://somephotosource.com/theNoon", 2014, "This Painting is about Noon", 99, 8, 5);
        art5.setUser(user4);
        user4.getPortfolios().add(art5);
        userRepository.save(user4);

        User user5 = new User("james", "james", "White", 2);
        Purchase purchase1 = new Purchase(user5, art1);
        user5.getCollections().add(purchase1);
        Purchase purchase2 = new Purchase(user5, art3);
        user5.getCollections().add(purchase2);
        userRepository.save(user5);

        User user6 = new User("alice", "john", "doe", 2);
        Purchase purchase3 = new Purchase(user6, art5);
        user6.getCollections().add(purchase3);
        userRepository.save(user6);

//        this.userRepository.save(new User("john", "john", "doe", 1));
//        this.userRepository.save(new User("janny", "janny", "Peters", 1));
//        this.userRepository.save(new User("tim", "Tim", "Johns", 1));
//        this.userRepository.save(new User("daniel", "daniel", "Woods", 2));
//        this.userRepository.save(new User("alice", "alice", "Vans", 2));


    }
}
