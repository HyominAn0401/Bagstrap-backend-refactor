package com.bagstrap.education.controller;

import com.bagstrap.education.dto.request.EducationRequestDto;
import com.bagstrap.education.dto.response.EducationResponseDto;
import com.bagstrap.education.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/education/{userId}")
    public ResponseEntity<?> getEducation(@PathVariable Long userId){
        try{
            // service로 dto
            EducationResponseDto educationResponseDto = educationService.getEducation(userId);

            return ResponseEntity.ok(educationResponseDto);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{ \"status\": \"ERROR\", \"message\": \"" + e.getMessage() + "\" }");
        }
    }

    @PutMapping("/education/{userId}")
    public ResponseEntity<?> updateEducation(@PathVariable Long userId, @RequestBody EducationRequestDto educationRequestDto){
        try{
            educationService.updateEducation(userId, educationRequestDto);

            return ResponseEntity.ok("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \"" + e.getMessage() + "\" }");
        }
    }

    @DeleteMapping("/education/{userId}")
    public ResponseEntity<?> deleteEducation(@PathVariable Long userId){
        try{
            educationService.deleteEducation(userId);
            return ResponseEntity.ok("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \"" + e.getMessage() + "\" }");
        }
    }
}
