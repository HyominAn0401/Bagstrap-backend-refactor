package com.bagstrap.personalinfo.service;

import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import com.bagstrap.personalinfo.repository.PersonalInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    @Transactional
    public void savePersonalInfo(PersonalInfoRequestDto personalInfoRequestDto){
        // Dto - > Entity
        PersonalInfo personalInfo = personalInfoRequestDto.toEntity();
        // save entity
        personalInfoRepository.save(personalInfo);
    }
}
