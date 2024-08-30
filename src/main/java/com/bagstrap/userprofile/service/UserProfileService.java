package com.bagstrap.userprofile.service;

import com.bagstrap.education.entity.Education;
import com.bagstrap.education.repository.EducationRepository;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import com.bagstrap.personalinfo.repository.PersonalInfoRepository;
import com.bagstrap.userprofile.dto.request.UserProfileRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserProfileService {

    private final PersonalInfoRepository personalInfoRepository;
    private final EducationRepository educationRepository;

    @Transactional
    public void saveUserProfile(UserProfileRequestDto userProfileRequestDto){

        // 1. PersonalInfo 단일 저장
        PersonalInfo personalInfo = new PersonalInfo(
                userProfileRequestDto.getPersonalInfo().getEngLastName(),
                userProfileRequestDto.getPersonalInfo().getEngFirstName(),
                userProfileRequestDto.getPersonalInfo().getKorName(),
                userProfileRequestDto.getPersonalInfo().getOrganization(),
                userProfileRequestDto.getPersonalInfo().getOrganizationAddress(),
                userProfileRequestDto.getPersonalInfo().getEmail(),
                userProfileRequestDto.getPersonalInfo().getSecondaryEmail(),
                new PersonalInfo.Mobile(
                        userProfileRequestDto.getPersonalInfo().getMobile().getCountryCode(),
                        userProfileRequestDto.getPersonalInfo().getMobile().getPhoneNumber()
                ),
                userProfileRequestDto.getPersonalInfo().getCurrentStatus(),
                userProfileRequestDto.getPersonalInfo().getWebsite()
        );
        personalInfoRepository.save(personalInfo);

        // 2. Education 여러 개 저장
        userProfileRequestDto.getEducations().forEach(educationRequestDto -> {
            Education education = new Education(
                    educationRequestDto.getDegreeLevel(),
                    educationRequestDto.getUniversity(),
                    educationRequestDto.getDepartment(),
                    educationRequestDto.getUniversityLocation().getCountry(),
                    educationRequestDto.getUniversityLocation().getCity(),
                    educationRequestDto.getEducationPeriod().getEnrollment().getYear(),
                    educationRequestDto.getEducationPeriod().getEnrollment().getMonth(),
                    educationRequestDto.getEducationPeriod().getGraduation().getYear(),
                    educationRequestDto.getEducationPeriod().getGraduation().getMonth(),
                    educationRequestDto.getEducationPeriod().getIsCurrentlyEnrolled(),
                    educationRequestDto.getGpa().getValue(),
                    educationRequestDto.getGpa().getScale(),
                    educationRequestDto.getPaperTitle(),
                    educationRequestDto.getAdvisorName(),
                    educationRequestDto.getDegreeTitle()
            );
            educationRepository.save(education);
        });
    }
}
