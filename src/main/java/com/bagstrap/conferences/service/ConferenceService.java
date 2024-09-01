package com.bagstrap.conferences.service;

import com.bagstrap.conferences.dto.request.ConferenceRequestDto;
import com.bagstrap.conferences.dto.response.ConferenceResponseDto;
import com.bagstrap.conferences.entity.Conference;
import com.bagstrap.conferences.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public ConferenceResponseDto getConference(Long userId) {
        Conference conference = conferenceRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자가 없습니다: " + userId));

        // Entity -> DTO
        return new ConferenceResponseDto(
                conference.getConferenceTitle(),
                conference.getConferenceName(),
                conference.getAuthors(),
                conference.getAttendDate(),
                conference.getConferenceLocation(),
                conference.getAttendanceType()
        );
    }

    @Transactional
    public void updateConference(Long userId, ConferenceRequestDto conferenceRequestDto){
        Optional<Conference> conference = conferenceRepository.findById(userId);

        if(conference.isEmpty()){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }

        Conference conference1 = conference.get();

        conference1.setConferenceTitle(conferenceRequestDto.getConferenceTitle());
        conference1.setConferenceName(conferenceRequestDto.getConferenceName());
        conference1.setAuthors(conferenceRequestDto.getAuthors());
        conference1.setAttendDate(conferenceRequestDto.getAttendDate());
        conference1.setConferenceLocation(conferenceRequestDto.getConferenceLocation());
        conference1.setAttendanceType(conferenceRequestDto.getAttendanceType());

        // 저장
        conferenceRepository.save(conference1);
    }

    @Transactional
    public void deleteConference(Long userId){
        Conference conference = conferenceRepository.findById(userId).orElse(null);
        if(conference == null)
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);

        conferenceRepository.delete(conference);
    }
}
