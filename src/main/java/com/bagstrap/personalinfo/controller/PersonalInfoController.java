package com.bagstrap.personalinfo.controller;

import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.dto.response.PersonalInfoResponseDto;
import com.bagstrap.personalinfo.service.PersonalInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
