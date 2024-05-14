package com.personalProject.CarDealership.service;

import com.personalProject.CarDealership.model.UserModel;
import com.personalProject.CarDealership.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements com.personalProject.CarDealership.service.jwt.UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserModel> findUserByUsername(String username) {
        return userRepo.findAll().stream().filter(userModel -> userModel.getUsername().toLowerCase().contains(username.toLowerCase())).collect(Collectors.toList());
    }

    public void updateUser(long userId, UserModel updatedUser) {
        Optional<UserModel> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            if (updatedUser.getUsername() != null) {
                user.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getEmail() != null) {
                user.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getPassword() != null) {
                user.setPassword(updatedUser.getPassword());
            }
            userRepo.save(user);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }

    public void removeUser(Long userId){
        userRepo.deleteById(userId);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepo.findFirstByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
