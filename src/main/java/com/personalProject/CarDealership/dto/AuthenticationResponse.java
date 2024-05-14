package com.personalProject.CarDealership.dto;

import com.personalProject.CarDealership.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private UserRole userRole;

    private Long userId;

}
