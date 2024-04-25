package com.personalProject.CarDealership.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cars")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long carId;
    private double price;
    private String color;
    private Date dateOfFabrication;
    private double km;
    private int hp;
    private String drivetrain;
    private String transmission;
    private String fuelType;

    @ManyToOne
    @JoinColumn(name = "make_Id", nullable = false)
    @JsonBackReference
    private MakeModel carMake;

    public CarModel() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateOfFabrication() {
        return dateOfFabrication;
    }

    public void setDateOfFabrication(Date dateOfFabrication) {
        this.dateOfFabrication = dateOfFabrication;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public MakeModel getCarMake() {
        return carMake;
    }

    public void setCarMake(MakeModel carMake) {
        this.carMake = carMake;
    }


}
