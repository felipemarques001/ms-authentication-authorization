package com.felipe.msauthenticationauthorization.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    @Query(value =
            "SELECT * FROM TB_GROUP g " +
            "WHERE g.name = :name " +
            "AND g.application_id = :applicationId",
           nativeQuery = true
    )
    Optional<Group> findByNameAndApplicationId(@Param(value = "name") String name,
                                               @Param(value = "applicationId") UUID applicationId);

    @Query(value =
            "SELECT * FROM TB_GROUP g " +
            "WHERE g.application_id = :applicationId",
           nativeQuery = true
    )
    List<Group> findByApplicationId(@Param(value = "applicationId") UUID applicationId);
}
