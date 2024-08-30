package com.bagstrap.conferences.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRequestDto {

    private String conferenceTitle;
    private String conferenceName;
    private List<String> authors;
    private AttendDate attendDate;
    private ConferenceLocation conferenceLocation;
    private AttendanceType attendanceType;

}
