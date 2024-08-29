package com.bagstrap.education.controller;

import com.bagstrap.education.dto.request.EducationRequestDto;
import com.bagstrap.education.service.EducationService;
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
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/education")
    public ResponseEntity<?> saveEducation(@RequestBody EducationRequestDto educationRequestDto){
        try{
            // save
            educationService.saveEducation(educationRequestDto);

            return ResponseEntity.ok("{ \"status\": \"OK\" }");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \"" + e.getMessage() + "\" }");
        }
    }
}
