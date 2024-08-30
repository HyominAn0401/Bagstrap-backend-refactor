package com.bagstrap.education.service;

import com.bagstrap.education.dto.request.EducationRequestDto;
import com.bagstrap.education.dto.response.EducationResponseDto;
import com.bagstrap.education.entity.Education;
import com.bagstrap.education.repository.EducationRepository;
import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
//@RequiredArgsConstructor
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

    @Transactional(readOnly = true)
    public EducationResponseDto getEducation(Long userId){
        Optional<Education> education = educationRepository.findById(userId);

        // 사용자 없는 경우
        if(education.isEmpty()){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }

        // Entity -> DTO
        Education education1 = education.get();
        return new EducationResponseDto(
                userId.toString(),
                education1.getDegreeLevel(),
                education1.getUniversity(),
                education1.getDepartment(),
                new EducationResponseDto.UniversityLocationDto(education1.getUniversityCountry(), education1.getUniversityCity()),
                new EducationResponseDto.EducationPeriodDto(
                        new EducationResponseDto.EnrollmentDto(education1.getEnrollmentYear(), education1.getEnrollmentMonth()),
                        new EducationResponseDto.GraduationDto(education1.getGraduationYear(), education1.getGraduationMonth()),
                        education1.getIsCurrentlyEnrolled()
                ),
                new EducationResponseDto.GpaDto(education1.getGpaValue(), education1.getGpaScale()),
                education1.getPaperTitle(),
                education1.getAdvisorName(),
                education1.getDegreeTitle()

        );
    }

    @Transactional
    public void updateEducation(Long userId, EducationRequestDto educationRequestDto){
        Optional<Education> education = educationRepository.findById(userId);

        // 사용자가 없는 경우
        if(education.isEmpty()){
            throw new IllegalArgumentException(("사용자가 없습니다: "+userId));
        }

        Education education1 = education.get();

        // 업데이트
        education1.setDegreeLevel(educationRequestDto.getDegreeLevel());
        education1.setUniversity(educationRequestDto.getUniversity());
        education1.setDepartment(educationRequestDto.getDepartment());
        education1.setUniversityCountry(educationRequestDto.getUniversityLocation().getCountry());
        education1.setUniversityCity(educationRequestDto.getUniversityLocation().getCity());
        education1.setEnrollmentYear(educationRequestDto.getEducationPeriod().getEnrollment().getYear());
        education1.setEnrollmentMonth(educationRequestDto.getEducationPeriod().getEnrollment().getMonth());
        education1.setGraduationYear(educationRequestDto.getEducationPeriod().getGraduation().getYear());
        education1.setGraduationMonth(educationRequestDto.getEducationPeriod().getGraduation().getMonth());
        education1.setIsCurrentlyEnrolled(educationRequestDto.getEducationPeriod().getIsCurrentlyEnrolled());
        education1.setGpaValue(educationRequestDto.getGpa().getValue());
        education1.setGpaScale(educationRequestDto.getGpa().getScale());
        education1.setPaperTitle(educationRequestDto.getPaperTitle());
        education1.setAdvisorName(educationRequestDto.getAdvisorName());
        education1.setDegreeTitle(educationRequestDto.getDegreeTitle());

        educationRepository.save(education1);
    }

    @Transactional
    public void deleteEducation(Long userId){
        // 1. 대상 찾기
        Education education1 = educationRepository.findById(userId).orElse(null);
        // 2. 잘못된 요청 처리
        if(education1 == null){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }
        // 3. 대상 삭제
        educationRepository.delete(education1);
    }
}
