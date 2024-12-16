package com.makersacademy.schoolcompare.repository;

import com.makersacademy.schoolcompare.model.AnswerUpvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerUpvoteRepository  extends CrudRepository<AnswerUpvote, Long> {
}
