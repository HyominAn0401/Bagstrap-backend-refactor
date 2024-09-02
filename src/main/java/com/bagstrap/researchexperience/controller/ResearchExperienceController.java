package com.bagstrap.researchexperience.controller;

import com.bagstrap.researchexperience.dto.request.ResearchExperienceRequestDto;
import com.bagstrap.researchexperience.dto.response.ResearchExperienceResponseDto;
import com.bagstrap.researchexperience.entity.ResearchExperience;
import com.bagstrap.researchexperience.repository.ResearchExperienceRepository;
import com.bagstrap.researchexperience.service.ResearchExperienceService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class ResearchExperienceController {

    private final ResearchExperienceService researchExperienceService;
    
    @PostMapping("/research-experience")
    public ResponseEntity<?> saveResearchExperience(@RequestBody ResearchExperienceRequestDto researchExperienceRequestDto){
        try{
            // service
            researchExperienceService.saveResearchExperience(researchExperienceRequestDto);
            return ResponseEntity.ok().body(" \"status\": \"OK\" }");
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage());
        }
    }

    @GetMapping("/research-experience/{userId}")
    public ResponseEntity<?> getResearchExperience(@PathVariable Long userId){
        try{
            ResearchExperienceResponseDto researchExperienceResponseDto = researchExperienceService.getResearchExperience(userId);

            return ResponseEntity.ok(researchExperienceResponseDto);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+ e.getMessage()+"\" }");
        }
    }

    @PutMapping("/research-experience/{userId}")
    public ResponseEntity<?> updateResearchExperience(@PathVariable Long userId, @RequestBody ResearchExperienceRequestDto researchExperienceRequestDto){
        try{
            researchExperienceService.updateResearchExperience(userId, researchExperienceRequestDto);

            return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }

    @DeleteMapping("/research-experience/{userId}")
    public ResponseEntity<?> deleteResearchExperience(@PathVariable Long userId){
        try{
            researchExperienceService.deleteResearchExperience(userId);
            return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }
}
