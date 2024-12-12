package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByUsername(String username);
    public Optional<User> findUserByAuth0Id(String auth0Id);
}
