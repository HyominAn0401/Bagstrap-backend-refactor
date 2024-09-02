package com.bagstrap.projects.dto.response;

import com.bagstrap.projects.dto.request.ProjectRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {

    private String projectName;
    private String managingOrganization;
    private String managingCountry;
    private ProjectRequestDto.DatePeriod startDate;
    private ProjectRequestDto.DatePeriod endDate;
    private boolean isCurrentlyParticipating;
    private String role;
}
