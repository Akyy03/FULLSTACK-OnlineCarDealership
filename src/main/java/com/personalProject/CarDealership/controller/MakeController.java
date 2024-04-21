package com.personalProject.CarDealership.controller;

import com.personalProject.CarDealership.model.MakeModel;
import com.personalProject.CarDealership.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/makes")
public class MakeController {

    @Autowired
    private MakeService makeService;

    @PostMapping("/add")
    public ResponseEntity<String> addMake(@RequestBody MakeModel makeModel) {
        makeService.addMake(makeModel);
        return ResponseEntity.ok("Make/model added successfully!");
    }

    @GetMapping("/all")
    public List<MakeModel> getAllMakes() {
        return makeService.getAllMakes();
    }
}
