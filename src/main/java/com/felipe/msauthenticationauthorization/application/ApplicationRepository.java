package com.felipe.msauthenticationauthorization.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    boolean existsByAccessKey(String accessKey);

    Optional<Application> findByAccessKey(String accessKey);
}
