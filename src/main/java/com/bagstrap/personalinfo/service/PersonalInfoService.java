package com.bagstrap.personalinfo.service;

import com.bagstrap.personalinfo.dto.request.MobileDto;
import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.dto.response.PersonalInfoResponseDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import com.bagstrap.personalinfo.repository.PersonalInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Transactional
    public void updatePersonalInfo(Long userId, PersonalInfoRequestDto personalInfoRequestDto){
        Optional<PersonalInfo> personalInfo = personalInfoRepository.findById(userId);

        // 사용자가 없는 경우
        if(personalInfo.isEmpty()){
            throw new IllegalArgumentException(("사용자가 없습니다: "+userId));
        }

        PersonalInfo personalInfo1 = personalInfo.get();

        // 업데이트
        personalInfo1.setEngLastName(personalInfoRequestDto.getEngLastName());
        personalInfo1.setEngFirstName(personalInfoRequestDto.getEngFirstName());
        personalInfo1.setKorName(personalInfoRequestDto.getKorName());
        personalInfo1.setOrganization(personalInfoRequestDto.getOrganization());
        personalInfo1.setOrganizationAddress(personalInfoRequestDto.getOrganizationAddress());
        personalInfo1.setEmail(personalInfoRequestDto.getEmail());
        personalInfo1.setSecondaryEmail(personalInfoRequestDto.getSecondaryEmail());

        personalInfo1.setMobile(new PersonalInfo.Mobile(
                personalInfoRequestDto.getMobile().getCountryCode(),
                personalInfoRequestDto.getMobile().getPhoneNumber()
        ));
        personalInfo1.setCurrentStatus(personalInfoRequestDto.getCurrentStatus());
        personalInfo1.setWebsite(personalInfoRequestDto.getWebsite());

        personalInfoRepository.save(personalInfo1);
    }

    @Transactional
    public void deletePersonalInfo(Long userId){
        // 1 대상 찾기
        PersonalInfo personalInfo1 = personalInfoRepository.findById(userId).orElse(null);
        // 2. 잘못된 요청 처리
        if(personalInfo1 == null){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }
        // 3. 대상 삭제
        personalInfoRepository.delete(personalInfo1);
    }
}
