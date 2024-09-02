package com.bagstrap.researchexperience.dto.response;

import com.bagstrap.researchexperience.dto.request.DatePeriod;
import com.bagstrap.researchexperience.dto.request.PositionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResearchExperienceResponseDto {

    private PositionType position;
    private String customPosition;
    private String organization;
    private String department;
    private String country;
    private DatePeriod startDate;
    private DatePeriod endDate;
    private boolean isCurrentlyEmployed;
    private String roleDescription;
}
