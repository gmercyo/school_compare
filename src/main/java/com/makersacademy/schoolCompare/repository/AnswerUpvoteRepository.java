package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.AnswerUpvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerUpvoteRepository  extends CrudRepository<AnswerUpvote, Long> {
}
