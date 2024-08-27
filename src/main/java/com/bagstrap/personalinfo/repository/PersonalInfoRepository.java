package com.bagstrap.personalinfo.repository;

import com.bagstrap.personalinfo.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
