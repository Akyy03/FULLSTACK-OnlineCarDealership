package com.personalProject.CarDealership.service.auth;

import com.personalProject.CarDealership.dto.SignupRequest;
import com.personalProject.CarDealership.dto.UserDto;
import com.personalProject.CarDealership.enums.UserRole;
import com.personalProject.CarDealership.model.UserModel;
import com.personalProject.CarDealership.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepo userRepo;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {

        UserModel userModel = new UserModel();
        userModel.setUsername(signupRequest.getUsername());
        userModel.setEmail(signupRequest.getEmail());
        userModel.setPassword(signupRequest.getPassword());
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
