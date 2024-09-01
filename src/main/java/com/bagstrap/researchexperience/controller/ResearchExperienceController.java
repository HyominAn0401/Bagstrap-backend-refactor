package com.bagstrap.researchexperience.controller;

import com.bagstrap.researchexperience.dto.request.ResearchExperienceRequestDto;
import com.bagstrap.researchexperience.service.ResearchExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
