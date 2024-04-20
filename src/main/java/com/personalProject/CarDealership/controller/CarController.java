package com.personalProject.CarDealership.controller;

import com.personalProject.CarDealership.model.CarModel;
import com.personalProject.CarDealership.service.CarService;
import com.personalProject.CarDealership.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private MakeService makeService;

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarModel carModel) {
        carService.addCar(carModel);
        return ResponseEntity.ok("Car added successfully!");
    }


    @GetMapping("/all")
    public ResponseEntity<List<CarModel>> getAllCars() {
        List<CarModel> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }
}
