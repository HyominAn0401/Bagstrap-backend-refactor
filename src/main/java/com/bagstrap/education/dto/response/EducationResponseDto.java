package com.bagstrap.education.dto.response;

import com.bagstrap.education.dto.request.EducationPeriodDto;
import com.bagstrap.education.dto.request.GpaDto;
import com.bagstrap.education.dto.request.UniversityLocationDto;
import lombok.Getter;

@Getter
public class EducationResponseDto {

    private String degreeLevel;
    private String university;
    private String department;
    private UniversityLocationDto universityLocation;
    private EducationPeriodDto educationPeriod;
    private GpaDto gpa;
    private String paperTitle;
    private String advisorName;
    private String degreeTitle;
}
