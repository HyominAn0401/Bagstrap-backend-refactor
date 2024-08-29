package com.bagstrap.education.repository;

import com.bagstrap.education.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
