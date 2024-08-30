package com.bagstrap.conferences.entity;

import com.bagstrap.conferences.dto.request.AttendDate;
import com.bagstrap.conferences.dto.request.AttendanceType;
import com.bagstrap.conferences.dto.request.ConferenceLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conferenceTitle;
    private String conferenceName;
    private List<String> authors;
    private AttendDate attendDate;
    private ConferenceLocation conferenceLocation;
    private AttendanceType attendanceType;

    //public Conference(String conferenceTitle, String conferenceName, List<String> authors, AttendDate attendDate, ConferenceLocation conferenceLocation, )
}
