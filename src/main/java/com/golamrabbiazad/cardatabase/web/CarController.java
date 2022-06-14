package com.golamrabbiazad.cardatabase.web;

import com.golamrabbiazad.cardatabase.domain.Car;
import com.golamrabbiazad.cardatabase.repository.CarRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repo;

    public CarController(CarRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repo.findAll();
    }
}
