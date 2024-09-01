package com.bagstrap.researchexperience.dto.request;

import com.bagstrap.researchexperience.entity.ResearchExperience;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResearchExperienceRequestDto {

    private PositionType position;
    private String customPosition;
    private String organization;
    private String department;
    private String country;
    private DatePeriod startDate;
    private DatePeriod endDate;
    private boolean isCurrentlyEmployed;
    private String roleDescription;

    // Dto -> Entity
    public ResearchExperience toEntity(){
        return new ResearchExperience(
                position, customPosition, organization, department, country,
                startDate, endDate, isCurrentlyEmployed, roleDescription
        );
    }
}
