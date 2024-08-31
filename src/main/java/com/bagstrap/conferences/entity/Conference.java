package com.bagstrap.conferences.entity;

import com.bagstrap.conferences.dto.request.AttendDate;
import com.bagstrap.conferences.dto.request.AttendanceType;
import com.bagstrap.conferences.dto.request.ConferenceLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String conferenceTitle;
    @Column(nullable = false)
    private String conferenceName;
    @ElementCollection
    private List<String> authors;
    @Embedded
    private AttendDate attendDate;
    @Embedded
    private ConferenceLocation conferenceLocation;
    @Enumerated(EnumType.STRING)
    private AttendanceType attendanceType;

    public Conference(String conferenceTitle, String conferenceName, List<String> authors,
                      AttendDate attendDate, ConferenceLocation conferenceLocation, AttendanceType attendanceType) {
        this.conferenceTitle = conferenceTitle;
        this.conferenceName = conferenceName;
        this.authors = authors;
        this.attendDate = attendDate;
        this.conferenceLocation = conferenceLocation;
        this.attendanceType = attendanceType;
    }
}
