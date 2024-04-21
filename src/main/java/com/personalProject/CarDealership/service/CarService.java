package com.personalProject.CarDealership.service;

import com.personalProject.CarDealership.model.CarModel;
import com.personalProject.CarDealership.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public void addCar(CarModel carModel) {
        validateCar(carModel);
        carRepo.save(carModel);
    }

    private void validateCar(CarModel carModel) {
        if (carModel == null) {
            throw new IllegalArgumentException("Car model cannot be null.");
        }
        if (carModel.getPrice() <= 0) {
            throw new IllegalArgumentException("Car's price must be greater than 0.");
        }
        if (carModel.getKm() < 0) {
            throw new IllegalArgumentException("Car's mileage must be greater than 0.");
        }
        if (carModel.getHp() <= 0) {
            throw new IllegalArgumentException("Car's power must be greater than 0 (horsepower).");
        }
        if (carModel.getCarMake() == null) {
            throw new IllegalArgumentException("Car must have a valid Make/Model.");
        }
    }

    public List<CarModel> getAllCars() {
        return carRepo.findAll();
    }
}
