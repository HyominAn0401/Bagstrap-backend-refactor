package com.bagstrap.conferences.repository;

import com.bagstrap.conferences.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
