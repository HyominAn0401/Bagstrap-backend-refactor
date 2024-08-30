package com.bagstrap.userprofile.dto.request;

import com.bagstrap.education.dto.request.EducationRequestDto;
import com.bagstrap.personalinfo.dto.request.PersonalInfoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequestDto {

    private PersonalInfoRequestDto personalInfo;
    private List<EducationRequestDto> educations;

}
