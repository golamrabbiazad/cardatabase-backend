package com.golamrabbiazad.cardatabase;

import com.golamrabbiazad.cardatabase.domain.Car;
import com.golamrabbiazad.cardatabase.domain.Owner;
import com.golamrabbiazad.cardatabase.repository.CarRepository;
import com.golamrabbiazad.cardatabase.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    private final CarRepository repo;
    private final OwnerRepository ORepo;

    public CardatabaseApplication(CarRepository repo, OwnerRepository ORepo) {
        this.repo = repo;
        this.ORepo = ORepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            ORepo.save(owner1);
            ORepo.save(owner2);

            repo.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
            repo.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            repo.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
        };
    }
}
