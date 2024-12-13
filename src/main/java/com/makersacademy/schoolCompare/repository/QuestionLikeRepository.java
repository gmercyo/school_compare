package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.QuestionLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {
}
