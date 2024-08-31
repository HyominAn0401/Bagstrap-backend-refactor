package com.bagstrap.conferences.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceLocation {

    private String country;
    private String city;
}
