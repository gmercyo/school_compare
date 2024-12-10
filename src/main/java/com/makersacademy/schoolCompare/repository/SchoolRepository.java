package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {


    List<School> findByType(String type);

    List<School> findByGender(String gender);

    List<School> findByReligiousAffiliation(String religiousAffiliation);

    List<School> findBySenAvailability(Boolean senAvailability);

    List<School> findByCatchmentRadiusLessThanEqual(Double radius);

    List<School> findByLatitudeBetweenAndLongitudeBetween(
            Double minLat, Double maxLat, Double minLong, Double maxLong);
}

