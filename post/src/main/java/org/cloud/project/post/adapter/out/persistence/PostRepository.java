package org.cloud.project.post.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, String>{
    @Query("select p from PostEntity p where p.title = :titleValue")
    Optional<PostEntity> findByTitle(@Param("titleValue") String titleValue);
}
