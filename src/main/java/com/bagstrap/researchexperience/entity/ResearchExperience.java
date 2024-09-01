package com.bagstrap.researchexperience.entity;

import com.bagstrap.researchexperience.dto.request.DatePeriod;
import com.bagstrap.researchexperience.dto.request.PositionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResearchExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PositionType position;
    private String customPosition;
    private String organization;
    private String department;
    private String country;

    @Embedded
    private DatePeriod startDate;
    @Embedded
    private DatePeriod endDate;
    private boolean isCurrentlyEmployed;
    private String roleDescription;

    public ResearchExperience(PositionType position, String customPosition, String organization,
                              String department, String country, DatePeriod startDate, DatePeriod endDate,
                              boolean isCurrentlyEmployed, String roleDescription){
        this.position = position;
        this.customPosition = customPosition;
        this.organization = organization;
        this.department = department;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrentlyEmployed = isCurrentlyEmployed;
        this.roleDescription = roleDescription;
    }
}
