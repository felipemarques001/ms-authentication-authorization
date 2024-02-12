package com.felipe.msauthenticationauthorization.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value =
            "SELECT * FROM TB_USER u " +
            "WHERE u.username = :username " +
            "AND u.application_id = :applicationId",
            nativeQuery = true
    )
    Optional<User> findByUsernameAndApplicationId(@Param(value = "username") String username,
                                                  @Param(value = "applicationId") UUID applicationId);

    @Query(value =
            "SELECT * FROM TB_USER u " +
            "WHERE u.id = :userId " +
            "AND u.application_id = :applicationId",
           nativeQuery = true
    )
    Optional<User> findByIdAndApplicationId(@Param(value = "userId") UUID userId,
                                            @Param(value = "applicationId") UUID applicationId);
}
