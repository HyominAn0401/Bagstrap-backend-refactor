package com.bagstrap.personalinfo.service;

import com.bagstrap.personalinfo.dto.request.MobileDto;
import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.dto.response.PersonalInfoResponseDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import com.bagstrap.personalinfo.repository.PersonalInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    // 조회 작업 -> 데이터 변경 필요 X
    // Entity -> DTO
    @Transactional(readOnly = true)
    public PersonalInfoResponseDto getPersonalInfo(Long userId){
        Optional<PersonalInfo> personalInfo = personalInfoRepository.findById(userId);

        // 사용자가 없는 경우
        if(personalInfo.isEmpty()){
            throw new IllegalArgumentException("사용자가 없습니다 :"+userId);
        }

        //return new PersonalInfoResponseDto(personalInfo.get());

        // DB에서 entity 객체 가져오기
        PersonalInfo personalInfo1 = personalInfo.get();

        // Entity -> DTO
        MobileDto mobileDto = new MobileDto(
                personalInfo1.getMobile().getCountryCode(),
                personalInfo1.getMobile().getPhoneNumber()
        );

        return new PersonalInfoResponseDto(
                personalInfo1.getEngLastName(),
                personalInfo1.getEngFirstName(),
                personalInfo1.getKorName(),
                personalInfo1.getOrganization(),
                personalInfo1.getOrganizationAddress(),
                personalInfo1.getEmail(),
                personalInfo1.getSecondaryEmail(),
                mobileDto,
                personalInfo1.getCurrentStatus(),
                personalInfo1.getWebsite()
        );
    }
}
