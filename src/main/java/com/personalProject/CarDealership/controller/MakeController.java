package com.personalProject.CarDealership.controller;

import com.personalProject.CarDealership.model.MakeModel;
import com.personalProject.CarDealership.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
