package com.bagstrap.projects.service;

import com.bagstrap.projects.dto.request.ProjectRequestDto;
import com.bagstrap.projects.dto.response.ProjectResponseDto;
import com.bagstrap.projects.entity.Project;
import com.bagstrap.projects.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public void saveProject(ProjectRequestDto projectRequestDto){
        // DTO -> Entity
        Project project = projectRequestDto.toEntity();
        // save
        projectRepository.save(project);
    }

//    @Transactional(readOnly = true)
//    public ProjectResponseDto getProject(Long userId){
//        Optional<Project> project = projectRepository.findById(userId);
//
//        if(project.isEmpty())
//            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
//
//        // entity
//        Project project1 = project.get();
//
//        // entity -> DTO
//        return new ProjectResponseDto(
//                project1.getProjectName(),
//                project1.getManagingOrganization(),
//                project1.getManagingCountry(),
//                project1.getStartDate(),
//                project1.getEndDate(),
//                project1.isCurrentlyParticipating(),
//                project1.getRole()
//        );
//    }

    @Transactional(readOnly = true)
    public ProjectResponseDto getProject(Long userId) {
        Optional<Project> project = projectRepository.findById(userId);

        if (project.isEmpty()) {
            throw new IllegalArgumentException("사용자가 없습니다: " + userId);
        }

        // 엔티티 가져오기
        Project project1 = project.get();

        // 엔티티 -> DTO 변환
        return new ProjectResponseDto(
                project1.getProjectName(),
                project1.getManagingOrganization(),
                project1.getManagingCountry(),
                convertToDtoDatePeriod(project1.getStartDate()),
                convertToDtoDatePeriod(project1.getEndDate()),
                project1.isCurrentlyParticipating(),
                project1.getRole()
        );
    }

    // Project.DatePeriod -> ProjectRequestDto.DatePeriod 변환 메서드

    private ProjectRequestDto.DatePeriod convertToDtoDatePeriod(Project.DatePeriod datePeriod) {
        return new ProjectRequestDto.DatePeriod(datePeriod.getYear(), datePeriod.getMonth());
    }

    // ProjectRequestDto.DatePeriod -> Project.DatePeriod 변환 메서드
    private Project.DatePeriod convertToEntityDatePeriod(ProjectRequestDto.DatePeriod datePeriod) {
        return new Project.DatePeriod(datePeriod.getYear(), datePeriod.getMonth());
    }

    @Transactional
    public void updateProject(Long userId, ProjectRequestDto projectRequestDto){
        Optional<Project> project = projectRepository.findById(userId);

        if(project.isEmpty())
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);

        Project project1 = project.get();

        project1.setProjectName(projectRequestDto.getProjectName());
        project1.setManagingOrganization(projectRequestDto.getManagingOrganization());
        project1.setManagingCountry(projectRequestDto.getManagingCountry());
        project1.setStartDate(convertToEntityDatePeriod(projectRequestDto.getStartDate()));
        project1.setEndDate(convertToEntityDatePeriod(projectRequestDto.getEndDate()));
        project1.setCurrentlyParticipating(projectRequestDto.isCurrentlyParticipating());
        project1.setRole(projectRequestDto.getRole());

        projectRepository.save(project1);

    }

    @Transactional
    public void deleteProject(Long userId){
        Project project = projectRepository.findById(userId).orElse(null);
        if(project == null){
            throw new IllegalArgumentException("사용자가 없습니다: "+userId);
        }
        projectRepository.delete(project);
    }

}
