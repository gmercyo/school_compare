package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolLikeRepository extends CrudRepository<SchoolLike, Long> {
    @Query("SELECT s FROM SchoolLike sl JOIN School s ON sl.schoolId = s.id WHERE sl.userId = :userId")
    List<School> findSchoolsByUserId(Long userId);

    public Optional<SchoolLike> findByUserIdAndSchoolId(@Param("userId") Long userId, @Param("schoolId") Long schoolId);

    @Query("SELECT sl.userId IS NOT NULL " +
            "FROM School s " +
            "LEFT JOIN SchoolLike sl ON sl.schoolId = s.id AND sl.userId = :currentUser " +
            "WHERE s.id = :schoolId")
    boolean isLikedByCurrentUser(Long schoolId, Long currentUser);
}
