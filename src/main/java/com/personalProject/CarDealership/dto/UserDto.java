package com.personalProject.CarDealership.dto;

import com.personalProject.CarDealership.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String username;
    private String email;
    private UserRole userRole;
}
