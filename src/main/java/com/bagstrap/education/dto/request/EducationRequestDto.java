package com.bagstrap.education.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EducationRequestDto {

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
