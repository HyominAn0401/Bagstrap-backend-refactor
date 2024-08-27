package com.bagstrap.personalinfo.dto.request;

import com.bagstrap.personalinfo.entity.PersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class PersonalInfoRequestDto {

    private String engLastName;
    private String engFirstName;
    private String korName;
    private String organization;
    private String organizationAddress;
    private String email;
    private String secondaryEmail;
    private MobileDto mobile;
    private String currentStatus;
    private String website;

    // dto -> entity
    public PersonalInfo toEntity(){
        return new PersonalInfo(
                engLastName,
                engFirstName,
                korName,
                organization,
                organizationAddress,
                email,
                secondaryEmail,
                new PersonalInfo.Mobile(mobile.getCountryCode(), mobile.getPhoneNumber()),
                currentStatus,
                website
        );
    }
}
