package com.metaphorce.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metaphorce.assessment.models.AppUser;
import java.util.List;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    List<AppUser> findByEmail(String email);

    List<AppUser> findByName(String name);
}
