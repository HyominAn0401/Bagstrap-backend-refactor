package com.bagstrap.conferences.dto.response;

import com.bagstrap.conferences.dto.request.AttendDate;
import com.bagstrap.conferences.dto.request.AttendanceType;
import com.bagstrap.conferences.dto.request.ConferenceLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceResponseDto {

    private String conferenceTitle;
    private String conferenceName;
    private List<String> authors;
    private AttendDate attendDate;
    private ConferenceLocation conferenceLocation;
    private AttendanceType attendanceType;

}
