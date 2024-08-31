package com.bagstrap.conferences.dto.request;

import com.bagstrap.conferences.entity.Conference;
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


    //Dto -> Entity
    public Conference toEntity(){
        return new Conference(
                conferenceTitle,
                conferenceName,
                authors,
                attendDate,
                conferenceLocation,
                attendanceType
        );
    }
}
