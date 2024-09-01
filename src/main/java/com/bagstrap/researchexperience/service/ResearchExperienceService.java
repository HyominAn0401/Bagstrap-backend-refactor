package com.bagstrap.researchexperience.service;

import com.bagstrap.researchexperience.dto.request.ResearchExperienceRequestDto;
import com.bagstrap.researchexperience.entity.ResearchExperience;
import com.bagstrap.researchexperience.repository.ResearchExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ResearchExperienceService {

    private final ResearchExperienceRepository researchExperienceRepository;

    @Transactional
    public void saveResearchExperience(ResearchExperienceRequestDto researchExperienceRequestDto){
        // DTO -> Entity
        ResearchExperience researchExperience = researchExperienceRequestDto.toEntity();
        // save
        researchExperienceRepository.save(researchExperience);
    }


}
