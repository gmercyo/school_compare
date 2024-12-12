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
// +
//            "q.id, q.schoolId, q.userId, q.content, q.createdAt, u.username, " +
//            "FROM Question q " +
//            "JOIN User u ON q.userId = u.id " +
//            "WHERE q.schoolId = :schoolId " +
//            "ORDER BY q.createdAt DESC"

//@Query("SELECT new com.makersacademy.acebook.dto.PostWithData(" +
//            "p.id, p.userId, p.parentId, p.content, p.friendsOnly, p.dateTime, u.nickname, l.emoji, " +
//            "(SELECT COUNT(l1) FROM Like l1 WHERE l1.postId = p.id AND l1.emoji = '\uD83D\uDC4D'), " +
//            "(SELECT COUNT(l2) FROM Like l2 WHERE l2.postId = p.id AND l2.emoji = '\uD83D\uDE02'), " +
//            "(SELECT COUNT(l3) FROM Like l3 WHERE l3.postId = p.id AND l3.emoji = '\uD83D\uDE32')) " +
//            "FROM Post p " +
//            "JOIN User u ON p.userId = u.auth0Id " +
//            "LEFT JOIN Like l ON p.id = l.postId AND l.userId = :userId " +
//            "WHERE p.parentId IS NULL " +
//            "ORDER BY p.dateTime DESC")
//    public List<PostWithData> findAllWithData(@Param("userId") String currentUser);
