package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.modal.Question;
import com.app.zofeservice.modal.QuestionnaireAnswers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created By Shameera.A on 1/27/2020
 */
public class QnARepositoryCustomImpl implements QnARepositoryCustom  {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<QuestionnaireAnswers> getAllFittingCandidates(Map<Long, Integer> questionList) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<QuestionnaireAnswers> query = builder.createQuery(QuestionnaireAnswers.class);
        Root<QuestionnaireAnswers> results = query.from(QuestionnaireAnswers.class);

        Path<Question> questionId = results.get("question");
        Path<Integer> empAnswerScore = results.get("empAnswerScore");

        List<Predicate> predicates = new ArrayList<>();

        for (Long question : questionList.keySet()) {
            predicates.add(builder.and(builder.equal(questionId,question)));
            predicates.add(builder.and(builder.equal(empAnswerScore,questionList.get(question))));
        }
        query.select(results).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }
}
