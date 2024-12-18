package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByUsername(String username);
    public Optional<User> findUserByAuth0Id(String auth0Id);
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.savedSchools WHERE u.id = :id")
    Optional<User> findByIdWithSavedSchools(@Param("id") Long id);
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.reviews WHERE u.id = :id")
    Optional<User> findByIdWithReviews(@Param("id") Long id);


}
