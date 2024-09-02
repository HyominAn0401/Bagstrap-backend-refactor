package com.bagstrap.projects.dto.request;

import com.bagstrap.projects.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {

    private String projectName;
    private String managingOrganization;
    private String managingCountry;
    private DatePeriod startDate;
    private DatePeriod endDate;
    private boolean isCurrentlyParticipating;
    private String role;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class DatePeriod {
        private int year;
        private int month;
    }

    // dto -> Entity
    public Project toEntity(){
        return new Project(
                projectName,
                managingOrganization, managingCountry,
                convertToEntityDatePeriod(startDate), convertToEntityDatePeriod(endDate),
                isCurrentlyParticipating, role
        );
    }

    // ProjectRequestDto.DatePeriod -> Project.DatePeriod 변환 메서드
    // researchExperience랑 같아서 똑같이 DatePeriod를 썼더니 발생
    private Project.DatePeriod convertToEntityDatePeriod(DatePeriod datePeriod) {
        return new Project.DatePeriod(datePeriod.getYear(), datePeriod.getMonth());
    }
}
