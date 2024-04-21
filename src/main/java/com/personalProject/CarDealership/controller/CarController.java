package com.personalProject.CarDealership.controller;

import com.personalProject.CarDealership.model.CarModel;
import com.personalProject.CarDealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarModel carModel) {
        carService.addCar(carModel);
        return ResponseEntity.ok("Car added successfully!");
    }

    @GetMapping("/all")
    public List<CarModel> getAllCars() {
        return carService.getAllCars();
    }
}
