package com.bagstrap.projects.controller;

import com.bagstrap.projects.dto.request.ProjectRequestDto;
import com.bagstrap.projects.dto.response.ProjectResponseDto;
import com.bagstrap.projects.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    public ResponseEntity<?> saveProject(@RequestBody ProjectRequestDto projectRequestDto){
        try{
            // service
            projectService.saveProject(projectRequestDto);
            return ResponseEntity.ok().body(" \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" \"status\": \"ERROR\", \"message\": \""+e.getMessage());
        }
    }

    @GetMapping("/project/{userId}")
    public ResponseEntity<?> getProject(@PathVariable Long userId){
        try{
            ProjectResponseDto projectResponseDto = projectService.getProject(userId);
            return ResponseEntity.ok().body(projectResponseDto);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+ e.getMessage()+"\" }");
        }
    }

    @PutMapping("/project/{userId}")
    public ResponseEntity<?> updateProject(@PathVariable Long userId, @RequestBody ProjectRequestDto projectRequestDto){
        try{
            projectService.updateProject(userId, projectRequestDto);
            return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }

    @DeleteMapping("/project/{userId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long userId){
        try{
            projectService.deleteProject(userId);
            return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"status\": \"ERROR\", \"message\": \""+e.getMessage()+"\" }");
        }
    }
}
