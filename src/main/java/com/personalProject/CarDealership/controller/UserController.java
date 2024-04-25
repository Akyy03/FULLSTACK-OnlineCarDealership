package com.personalProject.CarDealership.controller;

import com.personalProject.CarDealership.model.UserModel;
import com.personalProject.CarDealership.repository.UserRepo;
import com.personalProject.CarDealership.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public void addUser(@RequestBody UserModel userModel) {
        userRepo.save(userModel);
    }

    @GetMapping("/all")
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/findById/{id}")
    public UserModel findUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @GetMapping("/findByUsername/{username}")
    public List<UserModel> findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable long userId, @RequestBody UserModel updatedUser) {
        userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok("User updated successfully!");
    }

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable(name = "userId") Long userId) {
        userService.removeUser(userId);
        return ResponseEntity.ok("User removed successfully");
    }

}
