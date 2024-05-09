package com.personalProject.CarDealership.service.auth;

import com.personalProject.CarDealership.dto.SignupRequest;
import com.personalProject.CarDealership.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}

