package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.QuestionLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {
}
