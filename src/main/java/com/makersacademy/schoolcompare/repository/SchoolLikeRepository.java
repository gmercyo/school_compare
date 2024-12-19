package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.Question;
import com.makersacademy.schoolcompare.model.Review;
import com.makersacademy.schoolcompare.model.School;
import com.makersacademy.schoolcompare.model.SchoolLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolLikeRepository extends CrudRepository<SchoolLike, Long> {
    @Query("SELECT s FROM SchoolLike sl JOIN School s ON sl.schoolId = s.id WHERE sl.userId = :userId")
    List<School> findSchoolsByUserId(Long userId);
}
