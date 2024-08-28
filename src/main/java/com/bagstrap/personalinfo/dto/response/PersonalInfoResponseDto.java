package com.bagstrap.personalinfo.dto.response;

import com.bagstrap.personalinfo.dto.request.MobileDto;
import com.bagstrap.personalinfo.entity.PersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoResponseDto {
//    private String status;
//
//    // 200 : OK
//    // error
//    private String message;

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

}
