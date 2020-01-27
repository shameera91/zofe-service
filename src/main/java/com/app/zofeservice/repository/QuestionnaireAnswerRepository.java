package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.modal.QuestionnaireAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface QuestionnaireAnswerRepository extends JpaRepository<QuestionnaireAnswers, Long> {

    @Query("SELECT q.employee FROM QuestionnaireAnswers q WHERE q.question.id = ?1 AND q.empAnswerScore >= ?2")
    List<Employee> getAllFittingCandidate(long questionId, Integer answerScore);

    @Query("SELECT q.empAnswerScore FROM QuestionnaireAnswers q WHERE q.question.id =?1 AND q.employee.id =?2")
    Optional<Integer> getQuestionAnswer(long questionId, long employeeId);
}
