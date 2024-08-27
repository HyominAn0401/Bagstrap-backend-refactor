package com.bagstrap.personalinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String engLastName;

    @Column(nullable = false)
    private String engFirstName;

    @Column(nullable = false)
    private String korName;

    @Column(nullable = false)
    private String organization;

    private String organizationAddress;

    @Column(nullable = false, unique = true)
    private String email;
    private String secondaryEmail;

    private String currentStatus;
    private String website;

    @Embedded
    private Mobile mobile;

    public PersonalInfo(String engLastName, String engFirstName, String korName, String organization, String organizationAddress,
                        String email, String secondaryEmail, Mobile mobile, String currentStatus, String website) {
        this.engLastName = engLastName;
        this.engFirstName = engFirstName;
        this.korName = korName;
        this.organization = organization;
        this.organizationAddress = organizationAddress;
        this.email = email;
        this.secondaryEmail = secondaryEmail;
        this.mobile = mobile;
        this.currentStatus = currentStatus;
        this.website = website;
    }

    @Embeddable
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Mobile{
        private String countryCode;
        private String phoneNumber;

    }
}
