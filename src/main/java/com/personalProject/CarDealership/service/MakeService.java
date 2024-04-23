package com.personalProject.CarDealership.service;

import com.personalProject.CarDealership.model.MakeModel;
import com.personalProject.CarDealership.repository.MakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<MakeModel> getAllMakes() {
        return makeRepo.findAll();
    }

    public MakeModel findMakeById(Long id) {
        return makeRepo.findById(id).orElse(null);
    }

    public List<MakeModel> findByMakeName(String make) {
        return makeRepo.findAll().stream().filter(makeModel -> makeModel.getMake().equalsIgnoreCase(make)).collect(Collectors.toList());
    }

    public List<MakeModel> findByModel(String model) {
        return makeRepo.findAll().stream().filter(makeModel -> makeModel.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
    }

    public void updateMake(long makeId, MakeModel updatedMake) {
        Optional<MakeModel> optionalMake = makeRepo.findById(makeId);
        if (optionalMake.isPresent()) {
            MakeModel make = optionalMake.get();
            if (updatedMake.getMake() != null) {
                make.setMake(updatedMake.getMake());
            }
            if (updatedMake.getModel() != null) {
                make.setModel(updatedMake.getModel());
            }
            makeRepo.save(make);
        } else {
            throw new IllegalArgumentException("Make with ID " + makeId + " not found.");
        }
    }

    public void removeMake(Long makeId) {
        makeRepo.deleteById(makeId);
    }

}
