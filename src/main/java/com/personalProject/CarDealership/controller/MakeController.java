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
        return ResponseEntity.ok("Make added successfully!");
    }

    @GetMapping("/all")
    public List<MakeModel> getAllMakes() {
        return makeService.getAllMakes();
    }

    @GetMapping("/findById/{id}")
    public MakeModel findMakeById(@PathVariable Long id) {
        return makeService.findMakeById(id);
    }

    @GetMapping("/findByMakeName/{make}")
    public List<MakeModel> findByMakeName(@PathVariable String make) {
        return makeService.findByMakeName(make);
    }

    @GetMapping("/findByModel/{model}")
    public List<MakeModel> findByModel(@PathVariable String model) {
        return makeService.findByModel(model);
    }

    @PutMapping("update/{makeId}")
    public ResponseEntity<String> updateMake(@PathVariable long makeId, @RequestBody MakeModel updatedMake) {
        makeService.updateMake(makeId, updatedMake);
        return ResponseEntity.ok("Make updated successfully!");
    }

    @DeleteMapping("/remove/{makeId}")
    public ResponseEntity<String> removeMake(@PathVariable(name = "makeId") Long id) {
        makeService.removeMake(id);
        return ResponseEntity.ok("Make removed successfully");
    }
}
