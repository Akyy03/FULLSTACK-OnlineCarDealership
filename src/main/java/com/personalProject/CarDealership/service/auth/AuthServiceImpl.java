package com.personalProject.CarDealership.service.auth;

import com.personalProject.CarDealership.dto.SignupRequest;
import com.personalProject.CarDealership.dto.UserDto;
import com.personalProject.CarDealership.enums.UserRole;
import com.personalProject.CarDealership.model.UserModel;
import com.personalProject.CarDealership.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepo userRepo;

    @PostConstruct
    public void createAdminAccount(){
        UserModel adminAccount = userRepo.findByUserRole(UserRole.ADMIN);
        if (adminAccount == null){
            UserModel newAdminAccount = new UserModel();
            newAdminAccount.setUsername("Admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.ADMIN);
            userRepo.save(newAdminAccount);
            System.out.println("Admin account created successfully!");
        }
    }

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {

        UserModel userModel = new UserModel();
        userModel.setUsername(signupRequest.getUsername());
        userModel.setEmail(signupRequest.getEmail());
        userModel.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        userModel.setUserRole(UserRole.CUSTOMER);
        UserModel createdUser = userRepo.save(userModel);
        UserDto userDto = new UserDto();
        userDto.setUserId(createdUser.getUserId());

        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepo.findFirstByEmail(email).isPresent();
    }
}
