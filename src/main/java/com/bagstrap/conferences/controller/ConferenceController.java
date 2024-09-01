package com.bagstrap.conferences.controller;

import com.bagstrap.conferences.dto.request.ConferenceRequestDto;
import com.bagstrap.conferences.dto.response.ConferenceResponseDto;
import com.bagstrap.conferences.service.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class ConferenceController {

    private final ConferenceService conferenceService;

    @PostMapping("/conference")
    public ResponseEntity<?> saveConference(@RequestBody ConferenceRequestDto conferenceRequestDto){
        try{
            // service 호출, 저장
            conferenceService.saveConference(conferenceRequestDto);
            return ResponseEntity.ok().body(" \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage());
        }
    }
    
    @GetMapping("/conference/{userId}")
    public ResponseEntity<?> getConference(@PathVariable Long userId){
        try{
            ConferenceResponseDto conferenceResponseDto = conferenceService.getConference(userId);
            return ResponseEntity.ok(conferenceResponseDto);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+ e.getMessage()+"\" }");
        }
    }

    @PutMapping("/conference/{userId}")
    public ResponseEntity<?> updateConference(@PathVariable Long userId, @RequestBody ConferenceRequestDto conferenceRequestDto){
        try{
            // service
            conferenceService.updateConference(userId, conferenceRequestDto);
            return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }

    @DeleteMapping("/conference/{userId}")
    public ResponseEntity<?> deleteConference(@PathVariable Long userId){
        try{
            //service
            conferenceService.deleteConference(userId);
            return ResponseEntity.ok("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }
}
