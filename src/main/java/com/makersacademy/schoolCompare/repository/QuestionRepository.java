package com.makersacademy.schoolCompare.repository;

import com.makersacademy.schoolCompare.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Query("SELECT q, u.username FROM Question q JOIN User u ON q.userId = u.id WHERE q.schoolId = :schoolId " )
    public List<Question> getAllBySchool(@Param("schoolId") Long schoolId);
}
