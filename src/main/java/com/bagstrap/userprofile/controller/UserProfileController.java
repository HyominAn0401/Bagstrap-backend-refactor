package com.bagstrap.userprofile.controller;

import com.bagstrap.userprofile.dto.request.UserProfileRequestDto;
import com.bagstrap.userprofile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/profile")
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfileRequestDto userProfileRequestDto){
        try{
            userProfileService.saveUserProfile(userProfileRequestDto);
            return ResponseEntity.ok("{ \"status\": \"OK\" }");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"statys\": \"ERROR\", \"message\": \""+ e.getMessage()+"\" }");
        }
    }
}
