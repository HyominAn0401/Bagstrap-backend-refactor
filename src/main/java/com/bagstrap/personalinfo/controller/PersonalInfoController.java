package com.bagstrap.personalinfo.controller;

import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.dto.response.PersonalInfoResponseDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import com.bagstrap.personalinfo.service.PersonalInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @PostMapping("/personal-info")
    public ResponseEntity<?> savePersonalInfo(@RequestBody PersonalInfoRequestDto personalInfoRequestDto){
        try{
            // service 호출, 개인정보 저장
            personalInfoService.savePersonalInfo(personalInfoRequestDto);

            // success
            return ResponseEntity.ok().body(" \"status\": \"OK\" }");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \status\": \"ERROR\", \"message\": \""+e.getMessage());
        }
    }

    @GetMapping("/personal-info/{userId}")
    public ResponseEntity<?> getPersonalInfo(@PathVariable Long userId){
        try{
            PersonalInfoResponseDto personalInfoResponseDto = personalInfoService.getPersonalInfo(userId);

            return ResponseEntity.ok(personalInfoResponseDto);
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+ e.getMessage()+"\" }");
        }
    }
}
