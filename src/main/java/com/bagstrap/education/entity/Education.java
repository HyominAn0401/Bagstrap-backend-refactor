package com.bagstrap.education.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degreeLevel;
    private String university;
    private String department;
    private String universityCountry;
    private String universityCity;
    private int enrollmentYear;
    private int enrollmentMonth;
    private int graduationYear;
    private int graduationMonth;
    private Boolean isCurrentlyEnrolled;
    private float gpaValue;
    private float gpaScale;
    private String paperTitle;
    private String advisorName;
    private String degreeTitle;

    public Education(String degreeLevel, String university, String department,
                     String universityCountry, String universityCity,
                     int enrollmentYear, int enrollmentMonth,
                     int graduationYear, int graduationMonth,
                     Boolean isCurrentlyEnrolled, float gpaValue, float gpaScale,
                     String paperTitle, String advisorName, String degreeTitle) {
        this.degreeLevel = degreeLevel;
        this.university = university;
        this.department = department;
        this.universityCountry = universityCountry;
        this.universityCity = universityCity;
        this.enrollmentYear = enrollmentYear;
        this.enrollmentMonth = enrollmentMonth;
        this.graduationYear = graduationYear;
        this.graduationMonth = graduationMonth;
        this.isCurrentlyEnrolled = isCurrentlyEnrolled;
        this.gpaValue = gpaValue;
        this.gpaScale = gpaScale;
        this.paperTitle = paperTitle;
        this.advisorName = advisorName;
        this.degreeTitle = degreeTitle;
    }
}
