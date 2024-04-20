package com.personalProject.CarDealership.service;

import com.personalProject.CarDealership.model.MakeModel;
import com.personalProject.CarDealership.repository.MakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeService {

    @Autowired
    private MakeRepo makeRepo;

    public void addMake(MakeModel makeModel) {
        validateMake(makeModel);
        makeRepo.save(makeModel);
    }

    private void validateMake(MakeModel makeModel) {
        if (makeModel.getMake().isEmpty()) {
            throw new IllegalArgumentException("Empty car make name.");
        }
        if (makeModel.getModel().isEmpty()) {
            throw new IllegalArgumentException("Empty car model name.");
        }
    }

}
