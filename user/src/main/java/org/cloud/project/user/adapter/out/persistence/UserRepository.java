package org.cloud.project.user.adapter.out.persistence;

import org.cloud.project.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u where u.formId = :fromIdValue")
    Optional<UserEntity> findByFormId(@Param("fromIdValue") String formIdValue);
}
