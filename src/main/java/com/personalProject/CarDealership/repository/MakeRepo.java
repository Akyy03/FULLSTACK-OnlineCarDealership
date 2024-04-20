package com.personalProject.CarDealership.repository;

import com.personalProject.CarDealership.model.MakeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepo extends JpaRepository<MakeModel, Long> {
}
