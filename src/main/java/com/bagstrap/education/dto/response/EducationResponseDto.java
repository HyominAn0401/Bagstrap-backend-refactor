package com.bagstrap.education.dto.response;

import com.bagstrap.education.dto.request.EducationPeriodDto;
import com.bagstrap.education.dto.request.GpaDto;
import com.bagstrap.education.dto.request.UniversityLocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponseDto {

    private String userID;
    private String degreeLevel;
    private String university;
    private String department;
    private UniversityLocationDto universityLocation;
    private EducationPeriodDto educationPeriod;
    private GpaDto gpa;
    private String paperTitle;
    private String advisorName;
    private String degreeTitle;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UniversityLocationDto {
        private String country;
        private String city;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EducationPeriodDto {
        private EnrollmentDto enrollment;
        private GraduationDto graduation;
        private Boolean isCurrentlyEnrolled;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnrollmentDto {
        private int year;
        private int month;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraduationDto {
        private int year;
        private int month;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GpaDto {
        private float value;
        private float scale;
    }
}
