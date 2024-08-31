package com.bagstrap.conferences.service;

import com.bagstrap.conferences.dto.request.ConferenceRequestDto;
import com.bagstrap.conferences.entity.Conference;
import com.bagstrap.conferences.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Transactional
    public void saveConference(ConferenceRequestDto conferenceRequestDto){
        // DTO -> Entity
        Conference conference = conferenceRequestDto.toEntity();
        // save entity
        conferenceRepository.save(conference);

    }
}
