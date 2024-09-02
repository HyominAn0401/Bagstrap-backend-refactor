package com.bagstrap.projects.entity;

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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String managingOrganization;
    private String managingCountry;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "start_year")),
            @AttributeOverride(name = "month", column = @Column(name = "start_month"))
    })
    private DatePeriod startDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "end_year")),
            @AttributeOverride(name = "month", column = @Column(name = "end_month"))
    })
    private DatePeriod endDate;

    private boolean isCurrentlyParticipating;
    private String role;

    public Project(String projectName, String managingOrganization, String managingCountry, DatePeriod startDate, DatePeriod endDate, boolean isCurrentlyParticipating, String role){
        this.projectName = projectName;
        this.managingOrganization = managingOrganization;
        this.managingCountry = managingCountry;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrentlyParticipating = isCurrentlyParticipating;
        this.role = role;
    }

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatePeriod {
        private int year;
        private int month;
    }

}
