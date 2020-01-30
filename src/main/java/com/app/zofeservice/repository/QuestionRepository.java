package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Answer;
import com.app.zofeservice.modal.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query(value = "UPDATE Question q SET q.question = ?1 , q.answers = ?2 WHERE q.id = ?3")
    void updateQuestion(String question, List<Answer> answers, long id);
}
