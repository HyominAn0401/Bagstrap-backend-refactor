package com.bagstrap.education.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EducationPeriodDto {
    private EnrollmentDto enrollment;
    private GraduationDto graduation;
    private Boolean isCurrentlyEnrolled;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnrollmentDto{
        private int year;
        private int month;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraduationDto{
        private int year;
        private int month;
    }
}
