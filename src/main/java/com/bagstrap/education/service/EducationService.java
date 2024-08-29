package com.bagstrap.education.service;

import com.bagstrap.education.dto.request.EducationRequestDto;
import com.bagstrap.education.entity.Education;
import com.bagstrap.education.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EducationService {

    private final EducationRepository educationRepository;

    @Transactional
    public void saveEducation(EducationRequestDto educationRequestDto){
        // Dto -> Entity
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
    }
}
