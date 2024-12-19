package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.dto.NearbySchool;
import com.makersacademy.schoolcompare.model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

    Optional<School> findById(Long id);

    @Query("SELECT s FROM School s " +
            "WHERE (:ages = 'all' OR s.type = :ages) " +
            "AND (:gender = 'any' OR s.gender = :gender) " +
            "AND (s.ofstedRating >= :rating) " +
            "AND (:affiliation = 'any' OR s.religiousAffiliation = :affiliation)")
    List<School> findSchoolsByFilterCriteria(
            @Param("ages") String ages,
            @Param("gender") String gender,
            @Param("rating") Integer rating,
            @Param("affiliation") String affiliation);

    List<School> findByType(String type);

    List<School> findByGender(String gender);

    List<School> findByReligiousAffiliation(String religiousAffiliation);

    List<School> findBySenAvailability(String senAvailability);

    List<School> findByLatitudeBetweenAndLongitudeBetween(
            BigDecimal minLat, BigDecimal maxLat, BigDecimal minLong, BigDecimal maxLong);
}

