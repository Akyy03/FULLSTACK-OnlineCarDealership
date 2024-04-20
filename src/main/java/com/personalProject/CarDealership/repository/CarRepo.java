package com.personalProject.CarDealership.repository;

import com.personalProject.CarDealership.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<CarModel, Long> {
}
