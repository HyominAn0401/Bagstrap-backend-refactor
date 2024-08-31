package com.bagstrap.conferences.controller;

import com.bagstrap.conferences.dto.request.ConferenceRequestDto;
import com.bagstrap.conferences.service.ConferenceService;
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
    

}
