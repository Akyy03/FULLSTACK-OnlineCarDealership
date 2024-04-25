package com.personalProject.CarDealership.service;

import com.personalProject.CarDealership.model.CarModel;
import com.personalProject.CarDealership.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public void addCar(CarModel carModel) {
        validateCar(carModel);
        carRepo.save(carModel);
    }

    private void validateCar(CarModel carModel) {
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

    public CarModel findCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    public List<CarModel> findCarByColor(String color) {
        return carRepo.findAll().stream().filter(carModel -> carModel.getColor().toLowerCase().contains(color.toLowerCase())).collect(Collectors.toList());
    }

    public List<CarModel> findCarByDrivetrain(String drivetrain) {
        return carRepo.findAll().stream().filter(carModel -> carModel.getDrivetrain().toLowerCase().contains(drivetrain.toLowerCase())).collect(Collectors.toList());
    }

    public List<CarModel> findCarByFuelType(String fuelType) {
        return carRepo.findAll().stream().filter(carModel -> carModel.getFuelType().toLowerCase().contains(fuelType.toLowerCase())).collect(Collectors.toList());
    }

    public List<CarModel> findCarByTransmission(String transmission) {
        return carRepo.findAll().stream().filter(carModel -> carModel.getTransmission().toLowerCase().contains(transmission.toLowerCase())).collect(Collectors.toList());
    }

    public List<CarModel> findCarByHp(int minHp, int maxHp) {
        List<CarModel> allCars = carRepo.findAll();
        return allCars.stream().filter(carModel -> carModel.getHp() >= minHp && carModel.getHp() <= maxHp).collect(Collectors.toList());
    }

    public List<CarModel> findCarByKm(double minKm, double maxKm) {
        List<CarModel> allCars = carRepo.findAll();
        return allCars.stream().filter(carModel -> carModel.getKm() >= minKm && carModel.getKm() <= maxKm).collect(Collectors.toList());
    }

    public List<CarModel> findCarByPrice(double minPrice, double maxPrice) {
        List<CarModel> allCars = carRepo.findAll();
        return allCars.stream().filter(carModel -> carModel.getPrice() >= minPrice && carModel.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    public List<CarModel> findCarByYear(int minYear, int maxYear) {
        return carRepo.findAll().stream().filter(carModel -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(carModel.getDateOfFabrication());
            int year = cal.get(Calendar.YEAR);
            return year >= minYear && year <= maxYear;
        }).collect(Collectors.toList());
    }

    public void updateCar(long carId, CarModel updatedCar) {
        Optional<CarModel> optionalCar = carRepo.findById(carId);
        if (optionalCar.isPresent()) {
            CarModel car = optionalCar.get();
            if (updatedCar.getPrice() != 0) {
                car.setPrice(updatedCar.getPrice());
            }
            if (updatedCar.getColor() != null) {
                car.setColor(updatedCar.getColor());
            }
            if (updatedCar.getDateOfFabrication() != null) {
                car.setDateOfFabrication(updatedCar.getDateOfFabrication());
            }
            if (updatedCar.getKm() != 0) {
                car.setKm(updatedCar.getKm());
            }
            if (updatedCar.getHp() != 0) {
                car.setHp(updatedCar.getHp());
            }
            if (updatedCar.getDrivetrain() != null) {
                car.setDrivetrain(updatedCar.getDrivetrain());
            }
            if (updatedCar.getTransmission() != null) {
                car.setTransmission(updatedCar.getTransmission());
            }
            if (updatedCar.getFuelType() != null) {
                car.setFuelType(updatedCar.getFuelType());
            }
            carRepo.save(car);
        } else {
            throw new IllegalArgumentException("Car with ID " + carId + " not found.");
        }
    }

    public void removeCar(Long carId) {
        carRepo.deleteById(carId);
    }

}
