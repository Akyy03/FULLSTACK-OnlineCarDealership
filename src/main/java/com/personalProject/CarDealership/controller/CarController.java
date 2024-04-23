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

    @GetMapping("/findById/{id}")
    public CarModel findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @GetMapping("/findByColor/{color}")
    public List<CarModel> findCarByColor(@PathVariable String color) {
        return carService.findCarByColor(color);
    }

    @GetMapping("/findByDrivetrain/{drivetrain}")
    public List<CarModel> findCarByDrivetrain(@PathVariable String drivetrain) {
        return carService.findCarByDrivetrain(drivetrain);
    }

    @GetMapping("/findByFuelType/{fuelType}")
    public List<CarModel> findCarByFuelType(@PathVariable String fuelType) {
        return carService.findCarByFuelType(fuelType);
    }

    @GetMapping("/findByTransmission/{transmission}")
    public List<CarModel> findCarByTransmission(@PathVariable String transmission) {
        return carService.findCarByTransmission(transmission);
    }

    // localhost:8080/cars/findByHp?minHp=80&maxHp=700
    @GetMapping("/findByHp")
    public ResponseEntity<List<CarModel>> findCarByHp(@RequestParam("minHp") int minHp, @RequestParam("maxHp") int maxHp) {
        List<CarModel> filteredCars = carService.findCarByHp(minHp, maxHp);
        return ResponseEntity.ok(filteredCars);
    }

    // localhost:8080/cars/findByKm?minKm=10000&maxKm=240000
    @GetMapping("/findByKm")
    public ResponseEntity<List<CarModel>> findCarByKm(@RequestParam("minKm") double minKm, @RequestParam("maxKm") double maxKm) {
        List<CarModel> filteredCars = carService.findCarByKm(minKm, maxKm);
        return ResponseEntity.ok(filteredCars);
    }

    // localhost:8080/cars/findByPrice?minPrice=4500&maxKm=335000
    @GetMapping("/findByPrice")
    public ResponseEntity<List<CarModel>> findCarByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice) {
        List<CarModel> filteredCars = carService.findCarByPrice(minPrice, maxPrice);
        return ResponseEntity.ok(filteredCars);
    }

    // localhost:8080/cars/findByYear?minYear=1980&maxYear=2024
    @GetMapping("/findByYear")
    public ResponseEntity<List<CarModel>> findCarByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        List<CarModel> filteredCars = carService.findCarByYear(minYear, maxYear);
        return ResponseEntity.ok(filteredCars);
    }

    @PutMapping("/update/{carId}")
    public ResponseEntity<String> updateCar(@PathVariable long carId, @RequestBody CarModel updatedCar) {
        carService.updateCar(carId, updatedCar);
        return ResponseEntity.ok("Car updated successfully!");
    }

    @DeleteMapping("/remove/{carId}")
    public ResponseEntity<String> removeCar(@PathVariable(name = "carId") Long carId) {
        carService.removeCar(carId);
        return ResponseEntity.ok("Car removed successfully");
    }

}
