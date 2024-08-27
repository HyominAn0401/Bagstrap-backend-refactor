package com.bagstrap.personalinfo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {
    private String countryCode;
    private String phoneNumber;
}
