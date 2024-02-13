package com.felipe.msauthenticationauthorization.user;

import com.felipe.msauthenticationauthorization.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Query(value =
            "SELECT * FROM TB_USER u " +
            "INNER JOIN TB_USER_GROUP ug " +
            "ON u.id = ug.user_id " +
            "WHERE ug.group_id = :groupId",
           nativeQuery = true
    )
    List<User> findByGroupId(@Param(value = "groupId") UUID groupId);

    @Query(value =
            "SELECT * FROM TB_USER u " +
            "WHERE u.application_id = :applicationId",
           nativeQuery = true
    )
    List<User> findByApplicationId(@Param(value = "applicationId") UUID applicationId);
}
