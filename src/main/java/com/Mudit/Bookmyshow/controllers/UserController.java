package com.Mudit.Bookmyshow.controllers;

import com.Mudit.Bookmyshow.DTO.SignupRequestDto;
import com.Mudit.Bookmyshow.DTO.SignupResponseDto;
import com.Mudit.Bookmyshow.model.ResponseStatus;
import com.Mudit.Bookmyshow.model.User;
import com.Mudit.Bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    SignupResponseDto signup(SignupRequestDto signupRequestDto){
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        try{
            User user = userService.signup(signupRequestDto.getEmail(), signupRequestDto.getPassword());
            signupResponseDto.setUserId(user.getId());
            signupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            signupResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signupResponseDto;
    }
}
