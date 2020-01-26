package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.modal.QuestionnaireAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface QuestionnaireAnswerRepository extends JpaRepository<QuestionnaireAnswers,Long> {


    int getQuestionAnswer(Employee employee, Integer questionIdx);
}
