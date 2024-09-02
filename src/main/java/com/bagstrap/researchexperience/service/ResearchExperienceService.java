package com.bagstrap.researchexperience.service;

import com.bagstrap.researchexperience.dto.request.ResearchExperienceRequestDto;
import com.bagstrap.researchexperience.dto.response.ResearchExperienceResponseDto;
import com.bagstrap.researchexperience.entity.ResearchExperience;
import com.bagstrap.researchexperience.repository.ResearchExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    public ResearchExperienceResponseDto getResearchExperience(Long userId){
        Optional<ResearchExperience> researchExperience = researchExperienceRepository.findById(userId);

        if(researchExperience.isEmpty()){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }

        // entity
        ResearchExperience researchExperience1 = researchExperience.get();

        // entity -> DTO
        return new ResearchExperienceResponseDto(
                researchExperience1.getPosition(),
                researchExperience1.getCustomPosition(),
                researchExperience1.getOrganization(),
                researchExperience1.getDepartment(),
                researchExperience1.getCountry(),
                researchExperience1.getStartDate(),
                researchExperience1.getEndDate(),
                researchExperience1.isCurrentlyEmployed(),
                researchExperience1.getRoleDescription()
        );
    }

    @Transactional
    public void updateResearchExperience(Long userId, ResearchExperienceRequestDto researchExperienceRequestDto){
        Optional<ResearchExperience> researchExperience = researchExperienceRepository.findById(userId);

        if(researchExperience.isEmpty()){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }

        ResearchExperience researchExperience1 = researchExperience.get();

        researchExperience1.setPosition(researchExperienceRequestDto.getPosition());
        researchExperience1.setCustomPosition(researchExperienceRequestDto.getCustomPosition());
        researchExperience1.setOrganization(researchExperienceRequestDto.getOrganization());
        researchExperience1.setDepartment(researchExperienceRequestDto.getDepartment());
        researchExperience1.setCountry(researchExperienceRequestDto.getCountry());
        researchExperience1.setStartDate(researchExperienceRequestDto.getStartDate());
        researchExperience1.setEndDate(researchExperienceRequestDto.getEndDate());
        researchExperience1.setCurrentlyEmployed(researchExperienceRequestDto.isCurrentlyEmployed());
        researchExperience1.setRoleDescription(researchExperienceRequestDto.getRoleDescription());

        researchExperienceRepository.save(researchExperience1);
    }

    @Transactional
    public void deleteResearchExperience(Long userId){
        ResearchExperience researchExperience = researchExperienceRepository.findById(userId).orElse(null);
        if(researchExperience==null)
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);

        researchExperienceRepository.delete(researchExperience);
    }

}
