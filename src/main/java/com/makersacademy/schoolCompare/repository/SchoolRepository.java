package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {


    List<School> findByType(String type);

    List<School> findByGender(String gender);

    List<School> findByReligiousAffiliation(String religiousAffiliation);

    List<School> findBySenAvailability(String senAvailability);

    List<School> findByLatitudeBetweenAndLongitudeBetween(
            BigDecimal minLat, BigDecimal maxLat, BigDecimal minLong, BigDecimal maxLong);
}

